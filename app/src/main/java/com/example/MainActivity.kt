package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.CurriculumOffer
import com.example.model.SampleData
import com.example.model.TutorProfile
import com.example.ui.components.CurriculumDetailBottomSheet
import com.example.ui.components.DemoBookingBottomSheet
import com.example.ui.components.FeeCalculatorBottomSheet
import com.example.ui.components.FlyerCurriculumSection
import com.example.ui.components.FlyerFooterSection
import com.example.ui.components.FlyerHeader
import com.example.ui.components.FlyerHeroVisual
import com.example.ui.components.FlyerUrgentCTASection
import com.example.ui.components.FlyerWhyParentsChooseSection
import com.example.ui.components.VerifiedTutorsBottomSheet
import com.example.ui.theme.BrandEmerald
import com.example.ui.theme.BrandEmeraldDark
import com.example.ui.theme.BrandEmeraldLight
import com.example.ui.theme.BrandGold
import com.example.ui.theme.BrandGoldBright
import com.example.ui.theme.BrandGoldLight
import com.example.ui.theme.BrandNavy
import com.example.ui.theme.BrandNavyDark
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.theme.Slate100
import com.example.ui.theme.Slate200
import com.example.ui.theme.Slate300
import com.example.ui.theme.Slate50
import com.example.ui.theme.Slate600
import com.example.ui.theme.Slate700
import com.example.ui.theme.Slate800
import com.example.ui.theme.Slate900
import com.example.util.ContactUtils

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {
        LuckyTuitionsApp()
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LuckyTuitionsApp() {
  val context = LocalContext.current
  val scrollState = rememberScrollState()

  // Sheet states
  var showDemoSheet by remember { mutableStateOf(false) }
  var demoInitialGrade by remember { mutableStateOf("Class 10th") }
  var demoInitialBoard by remember { mutableStateOf("CBSE") }

  var selectedCurriculumForDetail by remember { mutableStateOf<CurriculumOffer?>(null) }
  var showFeeCalculator by remember { mutableStateOf(false) }
  var showVerifiedTutors by remember { mutableStateOf(false) }

  // Quick navigation tabs
  var selectedTab by remember { mutableIntStateOf(0) }
  val tabs = listOf(
    "Flyer View" to "🌟",
    "Curriculum" to "📚",
    "Why Choose Us" to "⭐",
    "Contact Desk" to "📞"
  )

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Row(
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(text = "🌟", fontSize = 18.sp, modifier = Modifier.padding(end = 6.dp))
            Column {
              Text(
                text = "LUCKY TUITIONS",
                color = BrandGoldBright,
                fontSize = 17.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 0.5.sp
              )
              Text(
                text = "Home Tuitions for All Classes",
                color = Slate200,
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium
              )
            }
          }
        },
        actions = {
          // Calculator Quick Action
          IconButton(onClick = { showFeeCalculator = true }) {
            Icon(
              imageVector = Icons.Default.Calculate,
              contentDescription = "Fee Calculator",
              tint = BrandGoldBright
            )
          }
          // Verified Tutors Action
          IconButton(onClick = { showVerifiedTutors = true }) {
            Icon(
              imageVector = Icons.Default.People,
              contentDescription = "Verified Faculty",
              tint = Color.White
            )
          }
          // Share Flyer Action
          IconButton(onClick = { ContactUtils.shareFlyer(context) }) {
            Icon(
              imageVector = Icons.Default.Share,
              contentDescription = "Share",
              tint = Color.White
            )
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = BrandNavyDark,
          titleContentColor = Color.White
        )
      )
    },
    bottomBar = {
      // Sticky bottom contact & booking strip
      Surface(
        color = BrandNavyDark,
        shadowElevation = 12.dp,
        border = BorderStroke(1.dp, Slate800)
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          // Direct Call button
          Button(
            onClick = { ContactUtils.dialDesk(context) },
            colors = ButtonDefaults.buttonColors(containerColor = BrandEmerald),
            shape = RoundedCornerShape(9999.dp),
            modifier = Modifier
              .weight(1f)
              .height(42.dp)
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.Center
            ) {
              Icon(Icons.Default.Call, contentDescription = null, tint = Color.White, modifier = Modifier.size(15.dp))
              Spacer(modifier = Modifier.width(4.dp))
              Text(
                text = "8520990880",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
              )
            }
          }

          // WhatsApp Button
          Button(
            onClick = { ContactUtils.openWhatsApp(context) },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF22C55E)),
            shape = RoundedCornerShape(9999.dp),
            modifier = Modifier
              .weight(1f)
              .height(42.dp)
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.Center
            ) {
              Text(text = "💬", fontSize = 14.sp)
              Spacer(modifier = Modifier.width(4.dp))
              Text(
                text = "WhatsApp",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
              )
            }
          }

          // Book Free Demo Button
          Button(
            onClick = { showDemoSheet = true },
            colors = ButtonDefaults.buttonColors(containerColor = BrandGold),
            shape = RoundedCornerShape(9999.dp),
            modifier = Modifier
              .weight(1.1f)
              .height(42.dp)
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.Center
            ) {
              Text(text = "🎓", fontSize = 13.sp)
              Spacer(modifier = Modifier.width(4.dp))
              Text(
                text = "Free Demo",
                color = BrandNavyDark,
                fontSize = 12.sp,
                fontWeight = FontWeight.ExtraBold
              )
            }
          }
        }
      }
    }
  ) { innerPadding ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .background(Slate100)
        .padding(innerPadding),
      contentAlignment = Alignment.TopCenter
    ) {
      // Centered Card Flyer Container (matches standard mobile width ~430px max on larger screens or fills phone)
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .verticalScroll(scrollState)
          .background(Color.White)
      ) {
        // 1. Top Brand Bar & Header Ribbon
        FlyerHeader(
          onBookDemoClick = { showDemoSheet = true }
        )

        // Quick Navigation Tabs below header for effortless jumping
        ScrollableTabRow(
          selectedTabIndex = selectedTab,
          containerColor = BrandNavy,
          contentColor = BrandGoldBright,
          edgePadding = 8.dp,
          indicator = { tabPositions ->
            TabRowDefaults.SecondaryIndicator(
              Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
              color = BrandGoldBright,
              height = 3.dp
            )
          }
        ) {
          tabs.forEachIndexed { index, (title, emoji) ->
            Tab(
              selected = selectedTab == index,
              onClick = { selectedTab = index },
              text = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text(text = emoji, fontSize = 12.sp, modifier = Modifier.padding(end = 4.dp))
                  Text(
                    text = title,
                    fontSize = 12.sp,
                    fontWeight = if (selectedTab == index) FontWeight.Bold else FontWeight.Medium,
                    color = if (selectedTab == index) BrandGoldBright else Slate300
                  )
                }
              }
            )
          }
        }

        // 2. Hero Visual Section (Classroom photo + Doorstep pill)
        FlyerHeroVisual(
          onImageClick = { showVerifiedTutors = true }
        )

        // Interactive Quick Actions Strip (Fee Guide, Verified Tutors, Testimonials)
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
          horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          QuickChipButton(
            icon = "📊",
            label = "Fee Calculator",
            modifier = Modifier.weight(1f),
            onClick = { showFeeCalculator = true }
          )
          QuickChipButton(
            icon = "👨‍🏫",
            label = "Verified Faculty",
            modifier = Modifier.weight(1f),
            onClick = { showVerifiedTutors = true }
          )
          QuickChipButton(
            icon = "🎓",
            label = "Book Demo",
            modifier = Modifier.weight(1f),
            onClick = { showDemoSheet = true }
          )
        }

        // 3. Classes & Curriculum Offered (CBSE, State, Inter MPC/BiPC/Commerce, Core Subjects)
        FlyerCurriculumSection(
          offers = SampleData.curriculumList,
          onOfferClick = { offer ->
            selectedCurriculumForDetail = offer
          }
        )

        Spacer(modifier = Modifier.height(6.dp))

        // 4. Why Parents Choose Lucky Tuitions (Top Rated + 7 Checklist points)
        FlyerWhyParentsChooseSection(
          onViewTutorsClick = { showVerifiedTutors = true }
        )

        // Parent Testimonial Carousel / Highlight
        ParentTestimonialsSection()

        // 5. Urgent Admissions CTA & Direct Contact Desk
        FlyerUrgentCTASection(
          onBookDemoClick = { showDemoSheet = true }
        )

        // 6. Tagline, Trust Badges, and Copyright Footer
        FlyerFooterSection(
          onShareClick = { ContactUtils.shareFlyer(context) }
        )

        // Extra padding at bottom to clear the persistent action bar
        Spacer(modifier = Modifier.height(16.dp))
      }
    }
  }

  // Bottom Sheets & Modals
  if (showDemoSheet) {
    DemoBookingBottomSheet(
      initialGrade = demoInitialGrade,
      initialBoard = demoInitialBoard,
      onDismiss = { showDemoSheet = false }
    )
  }

  selectedCurriculumForDetail?.let { offer ->
    CurriculumDetailBottomSheet(
      offer = offer,
      onDismiss = { selectedCurriculumForDetail = null },
      onRequestTutor = { selectedOffer ->
        demoInitialGrade = selectedOffer.targetGrades.split(" ").firstOrNull() ?: "Class 10th"
        demoInitialBoard = when {
          selectedOffer.id.contains("cbse") -> "CBSE"
          selectedOffer.id.contains("state") -> "State Board"
          else -> "CBSE"
        }
        showDemoSheet = true
      }
    )
  }

  if (showFeeCalculator) {
    FeeCalculatorBottomSheet(
      onDismiss = { showFeeCalculator = false },
      onBookNow = { showDemoSheet = true }
    )
  }

  if (showVerifiedTutors) {
    VerifiedTutorsBottomSheet(
      onDismiss = { showVerifiedTutors = false },
      onSelectTutor = { tutor ->
        showDemoSheet = true
      }
    )
  }
}

@Composable
private fun QuickChipButton(
  icon: String,
  label: String,
  modifier: Modifier = Modifier,
  onClick: () -> Unit
) {
  Surface(
    shape = RoundedCornerShape(10.dp),
    color = Slate50,
    border = BorderStroke(1.dp, Slate200),
    shadowElevation = 1.dp,
    modifier = modifier.clickable { onClick() }
  ) {
    Row(
      modifier = Modifier.padding(vertical = 7.dp, horizontal = 8.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Center
    ) {
      Text(text = icon, fontSize = 12.sp, modifier = Modifier.padding(end = 4.dp))
      Text(
        text = label,
        color = BrandNavy,
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        maxLines = 1
      )
    }
  }
}

@Composable
private fun ParentTestimonialsSection() {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(Color.White)
      .padding(horizontal = 16.dp, vertical = 12.dp)
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.padding(bottom = 10.dp)
    ) {
      Box(
        modifier = Modifier
          .width(6.dp)
          .height(18.dp)
          .clip(RoundedCornerShape(3.dp))
          .background(BrandGold)
      )
      Spacer(modifier = Modifier.width(8.dp))
      Text(
        text = "Parent Success Stories",
        color = BrandNavy,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
      )
    }

    SampleData.parentReviews.forEach { (quote, author) ->
      Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Slate50),
        border = BorderStroke(1.dp, Slate200),
        modifier = Modifier
          .fillMaxWidth()
          .padding(bottom = 8.dp)
      ) {
        Column(modifier = Modifier.padding(10.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            repeat(5) {
              Text(text = "⭐", fontSize = 10.sp)
            }
          }
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "“$quote”",
            color = Slate700,
            fontSize = 11.sp,
            lineHeight = 16.sp
          )
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "— $author",
            color = BrandNavy,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
          )
        }
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun LuckyTuitionsAppPreview() {
  MyApplicationTheme {
    LuckyTuitionsApp()
  }
}

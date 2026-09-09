package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.model.CurriculumOffer
import com.example.model.SampleData
import com.example.ui.theme.BrandEmerald
import com.example.ui.theme.BrandEmeraldDark
import com.example.ui.theme.BrandEmeraldLight
import com.example.ui.theme.BrandGold
import com.example.ui.theme.BrandGoldBright
import com.example.ui.theme.BrandGoldLight
import com.example.ui.theme.BrandGoldSoft
import com.example.ui.theme.BrandNavy
import com.example.ui.theme.BrandNavyDark
import com.example.ui.theme.BrandNavyLight
import com.example.ui.theme.Slate100
import com.example.ui.theme.Slate200
import com.example.ui.theme.Slate300
import com.example.ui.theme.Slate50
import com.example.ui.theme.Slate600
import com.example.ui.theme.Slate700
import com.example.ui.theme.Slate800
import com.example.ui.theme.Slate900
import com.example.util.ContactUtils

/**
 * Top brand bar matching the design flyer.
 */
@Composable
fun FlyerHeader(
  onBookDemoClick: () -> Unit = {}
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(
        brush = Brush.verticalGradient(
          colors = listOf(BrandNavy, BrandNavyDark)
        )
      )
      .padding(horizontal = 16.dp, vertical = 14.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    // Quality Education • Personal Attention • Better Results Ticker
    Surface(
      shape = RoundedCornerShape(9999.dp),
      color = Color.White.copy(alpha = 0.12f),
      border = BorderStroke(1.dp, BrandGoldBright.copy(alpha = 0.4f)),
      modifier = Modifier.padding(bottom = 10.dp)
    ) {
      Row(
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
      ) {
        Text(
          text = "⭐",
          fontSize = 11.sp,
          modifier = Modifier.padding(end = 4.dp)
        )
        Text(
          text = "QUALITY EDUCATION • PERSONAL ATTENTION • BETTER RESULTS",
          color = BrandGoldBright,
          fontSize = 10.sp,
          fontWeight = FontWeight.Bold,
          letterSpacing = 0.5.sp
        )
      }
    }

    // Main Brand Title
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Center,
      modifier = Modifier.fillMaxWidth()
    ) {
      Text(
        text = "🌟",
        fontSize = 24.sp,
        modifier = Modifier.padding(end = 6.dp)
      )
      Text(
        text = "LUCKY TUITIONS",
        color = BrandGoldBright,
        fontSize = 28.sp,
        fontWeight = FontWeight.ExtraBold,
        letterSpacing = 1.sp
      )
      Text(
        text = "🌟",
        fontSize = 24.sp,
        modifier = Modifier.padding(start = 6.dp)
      )
    }

    Text(
      text = "PREMIER HOME & PERSONAL COACHING ACADEMY",
      color = Slate200,
      fontSize = 11.sp,
      fontWeight = FontWeight.Medium,
      letterSpacing = 1.5.sp,
      textAlign = TextAlign.Center,
      modifier = Modifier.padding(top = 4.dp, bottom = 12.dp)
    )

    // Golden Ribbon: HOME TUITIONS FOR ALL CLASSES
    Surface(
      shape = RoundedCornerShape(12.dp),
      color = Color.Transparent,
      border = BorderStroke(1.dp, BrandGoldBright),
      modifier = Modifier
        .fillMaxWidth()
        .shadow(4.dp, RoundedCornerShape(12.dp))
        .clickable { onBookDemoClick() }
    ) {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .background(
            brush = Brush.horizontalGradient(
              colors = listOf(BrandGoldLight, BrandGold)
            )
          )
          .padding(vertical = 10.dp, horizontal = 12.dp),
        contentAlignment = Alignment.Center
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.Center
        ) {
          Text(
            text = "📚",
            fontSize = 16.sp,
            modifier = Modifier.padding(end = 6.dp)
          )
          Text(
            text = "HOME TUITIONS FOR ALL CLASSES",
            color = BrandNavyDark,
            fontSize = 14.sp,
            fontWeight = FontWeight.Black,
            letterSpacing = 0.5.sp
          )
        }
      }
    }
  }

  // Thin gold divider line
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .height(4.dp)
      .background(BrandGold)
  )
}

/**
 * Hero visual section with photo of teacher & students and bottom doorstep badge.
 */
@Composable
fun FlyerHeroVisual(
  onImageClick: () -> Unit = {}
) {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .background(
        brush = Brush.verticalGradient(
          colors = listOf(Slate50, Color.White)
        )
      )
      .padding(horizontal = 16.dp, vertical = 12.dp)
  ) {
    Card(
      shape = RoundedCornerShape(16.dp),
      border = BorderStroke(2.dp, BrandNavy.copy(alpha = 0.25f)),
      colors = CardDefaults.cardColors(containerColor = BrandNavy),
      elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
      modifier = Modifier
        .fillMaxWidth()
        .clickable { onImageClick() }
    ) {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .height(210.dp)
      ) {
        Image(
          painter = painterResource(id = R.drawable.tuition_hero),
          contentDescription = "Professional friendly home tutor teaching students at study table",
          contentScale = ContentScale.Crop,
          modifier = Modifier.fillMaxSize()
        )

        // Bottom Doorstep Badge Overlay
        Box(
          modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(BrandNavy.copy(alpha = 0.92f))
            .border(1.dp, BrandGoldBright.copy(alpha = 0.5f), RoundedCornerShape(10.dp))
            .padding(vertical = 8.dp, horizontal = 12.dp),
          contentAlignment = Alignment.Center
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
          ) {
            Text(
              text = "✨",
              fontSize = 13.sp,
              modifier = Modifier.padding(end = 4.dp)
            )
            Text(
              text = "Experienced & Verified Tutors at Your Doorstep",
              color = BrandGoldBright,
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold,
              textAlign = TextAlign.Center
            )
          }
        }
      }
    }
  }
}

/**
 * Classes & Curriculum Offered (2x2 grid + 1-on-1 banner)
 */
@Composable
fun FlyerCurriculumSection(
  offers: List<CurriculumOffer> = SampleData.curriculumList,
  onOfferClick: (CurriculumOffer) -> Unit
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp, vertical = 8.dp)
  ) {
    // Section Header
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.padding(bottom = 12.dp)
    ) {
      Box(
        modifier = Modifier
          .width(6.dp)
          .height(20.dp)
          .clip(RoundedCornerShape(3.dp))
          .background(BrandGold)
      )
      Spacer(modifier = Modifier.width(8.dp))
      Text(
        text = "Classes & Curriculum Offered",
        color = BrandNavy,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
      )
    }

    // 2x2 Grid of Curriculum Offerings
    Column(
      verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
      // Row 1: CBSE and State
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        if (offers.size >= 2) {
          CurriculumCard(
            offer = offers[0],
            bgColor = Color(0xFFFFFBEB), // warm amber tint
            borderColor = Color(0xFFFDE68A),
            modifier = Modifier.weight(1f),
            onClick = { onOfferClick(offers[0]) }
          )
          CurriculumCard(
            offer = offers[1],
            bgColor = Color(0xFFEFF6FF), // blue tint
            borderColor = Color(0xFFBFDBFE),
            modifier = Modifier.weight(1f),
            onClick = { onOfferClick(offers[1]) }
          )
        }
      }

      // Row 2: Intermediate and Core Subjects
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        if (offers.size >= 4) {
          CurriculumCard(
            offer = offers[2],
            bgColor = Color(0xFFECFDF5), // emerald tint
            borderColor = Color(0xFFA7F3D0),
            accentTextColor = BrandEmeraldDark,
            modifier = Modifier.weight(1f),
            onClick = { onOfferClick(offers[2]) }
          )
          CurriculumCard(
            offer = offers[3],
            bgColor = Color(0xFFFAF5FF), // purple tint
            borderColor = Color(0xFFE9D5FF),
            modifier = Modifier.weight(1f),
            onClick = { onOfferClick(offers[3]) }
          )
        }
      }
    }

    Spacer(modifier = Modifier.height(10.dp))

    // Feature Highlight Bar
    Surface(
      shape = RoundedCornerShape(12.dp),
      color = BrandNavyDark,
      border = BorderStroke(1.dp, Slate700),
      shadowElevation = 2.dp,
      modifier = Modifier
        .fillMaxWidth()
        .clickable {
          // Open fee / batch details
          if (offers.isNotEmpty()) onOfferClick(offers.first())
        }
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 10.dp, horizontal = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
      ) {
        Text(
          text = "🎯",
          fontSize = 15.sp,
          modifier = Modifier.padding(end = 8.dp)
        )
        Text(
          text = "Personalized 1-on-1 & Focused Small Group Coaching",
          color = Slate100,
          fontSize = 12.sp,
          fontWeight = FontWeight.SemiBold,
          textAlign = TextAlign.Center
        )
      }
    }
  }
}

@Composable
private fun CurriculumCard(
  offer: CurriculumOffer,
  bgColor: Color,
  borderColor: Color,
  accentTextColor: Color = Slate600,
  modifier: Modifier = Modifier,
  onClick: () -> Unit
) {
  Card(
    shape = RoundedCornerShape(12.dp),
    colors = CardDefaults.cardColors(containerColor = bgColor),
    border = BorderStroke(1.dp, borderColor),
    modifier = modifier
      .height(98.dp)
      .clickable { onClick() }
  ) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
      verticalArrangement = Arrangement.SpaceBetween
    ) {
      Row(
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = offer.iconEmoji,
          fontSize = 18.sp,
          modifier = Modifier.padding(end = 6.dp)
        )
        Text(
          text = offer.title,
          color = BrandNavy,
          fontSize = 12.sp,
          fontWeight = FontWeight.Bold,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis
        )
      }

      Text(
        text = offer.subtitle,
        color = accentTextColor,
        fontSize = 11.sp,
        fontWeight = if (accentTextColor != Slate600) FontWeight.Bold else FontWeight.Medium,
        lineHeight = 14.sp,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
      )
    }
  }
}

/**
 * Why Parents Choose Lucky Tuitions (with TOP RATED badge and 7 star points)
 */
@Composable
fun FlyerWhyParentsChooseSection(
  onViewTutorsClick: () -> Unit = {}
) {
  val benefits = listOf(
    "Individual One-on-One Attention" to null,
    "Experienced & Dedicated Subject Faculty" to null,
    "Concept-Based Learning" to "(No Rote Memorization)",
    "Regular Weekly Tests & Monthly Progress Reports" to null,
    "Dedicated Instant Doubt-Clearing Sessions" to null,
    "Exam-Oriented Prep & Previous Year Papers" to null,
    "Boost Marks & Build Confident Study Habits" to null
  )

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(Slate50)
      .border(
        width = 1.dp,
        color = Slate200,
        shape = RoundedCornerShape(0.dp)
      )
      .padding(horizontal = 16.dp, vertical = 14.dp)
  ) {
    // Header with "TOP RATED" badge
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Row(
        verticalAlignment = Alignment.CenterVertically
      ) {
        Box(
          modifier = Modifier
            .width(6.dp)
            .height(20.dp)
            .clip(RoundedCornerShape(3.dp))
            .background(BrandEmerald)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = "Why Parents Choose Lucky Tuitions",
          color = BrandNavy,
          fontSize = 16.sp,
          fontWeight = FontWeight.Bold
        )
      }

      Surface(
        shape = RoundedCornerShape(9999.dp),
        color = BrandEmeraldLight,
        modifier = Modifier.clickable { onViewTutorsClick() }
      ) {
        Text(
          text = "TOP RATED",
          color = BrandEmerald,
          fontSize = 10.sp,
          fontWeight = FontWeight.ExtraBold,
          letterSpacing = 0.5.sp,
          modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
        )
      }
    }

    Spacer(modifier = Modifier.height(12.dp))

    // List of 7 checklist items
    Column(
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      benefits.forEach { (mainText, extraNote) ->
        BenefitItem(mainText = mainText, extraNote = extraNote)
      }
    }
  }
}

@Composable
private fun BenefitItem(
  mainText: String,
  extraNote: String?
) {
  Card(
    shape = RoundedCornerShape(8.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    border = BorderStroke(1.dp, Slate200),
    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
    modifier = Modifier.fillMaxWidth()
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 8.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      // Star badge circle
      Box(
        modifier = Modifier
          .size(22.dp)
          .clip(CircleShape)
          .background(Color(0xFFFEF3C7)),
        contentAlignment = Alignment.Center
      ) {
        Text(
          text = "⭐",
          fontSize = 11.sp
        )
      }

      Spacer(modifier = Modifier.width(10.dp))

      Row(
        modifier = Modifier.weight(1f),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = mainText,
          color = Slate800,
          fontSize = 12.sp,
          fontWeight = FontWeight.SemiBold
        )
        if (extraNote != null) {
          Spacer(modifier = Modifier.width(4.dp))
          Text(
            text = extraNote,
            color = Slate600,
            fontSize = 11.sp,
            fontWeight = FontWeight.Normal
          )
        }
      }
    }
  }
}

/**
 * Direct Contact Desk & Admissions CTA
 */
@Composable
fun FlyerUrgentCTASection(
  onBookDemoClick: () -> Unit = {}
) {
  val context = LocalContext.current

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(Color.White)
      .padding(16.dp)
  ) {
    // Urgent Admissions Open Badge
    Surface(
      shape = RoundedCornerShape(12.dp),
      color = Color(0xFFFEF2F2), // red tint
      border = BorderStroke(1.dp, Color(0xFFFECACA)),
      modifier = Modifier
        .fillMaxWidth()
        .clickable { onBookDemoClick() }
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 9.dp, horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
      ) {
        Text(
          text = "🔥",
          fontSize = 14.sp,
          modifier = Modifier.padding(end = 6.dp)
        )
        Text(
          text = "Admissions Open for Academic Session – Limited Slots!",
          color = Color(0xFFDC2626),
          fontSize = 12.sp,
          fontWeight = FontWeight.Black,
          textAlign = TextAlign.Center
        )
      }
    }

    Spacer(modifier = Modifier.height(12.dp))

    // Direct Tutor Coordination Desk Card
    Card(
      shape = RoundedCornerShape(16.dp),
      colors = CardDefaults.cardColors(containerColor = BrandNavy),
      border = BorderStroke(2.dp, BrandGold),
      elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .background(
            brush = Brush.verticalGradient(
              colors = listOf(BrandNavy, BrandNavyDark)
            )
          )
          .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Text(
          text = "DIRECT TUTOR COORDINATION DESK",
          color = BrandGoldBright,
          fontSize = 11.sp,
          fontWeight = FontWeight.Bold,
          letterSpacing = 1.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Large Phone Number (Clickable to Dial)
        Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.Center,
          modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable { ContactUtils.dialDesk(context) }
            .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
          Text(
            text = "📞",
            fontSize = 20.sp,
            modifier = Modifier.padding(end = 6.dp)
          )
          Text(
            text = ContactUtils.PHONE_NUMBER,
            color = Color.White,
            fontSize = 26.sp,
            fontWeight = FontWeight.Black,
            letterSpacing = 1.sp
          )
        }

        Text(
          text = "Call or WhatsApp anytime for free consultation",
          color = Slate300,
          fontSize = 11.sp,
          modifier = Modifier.padding(top = 2.dp, bottom = 14.dp),
          textAlign = TextAlign.Center
        )

        // Two Action Buttons: Call Now & WhatsApp Us
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          // Call Now Button
          Button(
            onClick = { ContactUtils.dialDesk(context) },
            colors = ButtonDefaults.buttonColors(containerColor = BrandEmerald),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
              .weight(1f)
              .height(44.dp)
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.Center
            ) {
              Icon(
                imageVector = Icons.Default.Call,
                contentDescription = "Call Now",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
              )
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = "Call Now",
                color = Color.White,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
              )
            }
          }

          // WhatsApp Us Button
          Button(
            onClick = { ContactUtils.openWhatsApp(context) },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF22C55E)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
              .weight(1f)
              .height(44.dp)
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.Center
            ) {
              Text(
                text = "💬",
                fontSize = 14.sp
              )
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = "WhatsApp Us",
                color = Color.White,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
              )
            }
          }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Email Inquiry Button
        Surface(
          shape = RoundedCornerShape(12.dp),
          color = Color.White.copy(alpha = 0.12f),
          border = BorderStroke(1.dp, Color.White.copy(alpha = 0.25f)),
          modifier = Modifier
            .fillMaxWidth()
            .clickable { ContactUtils.sendEmail(context) }
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 10.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
          ) {
            Text(
              text = "📧",
              fontSize = 13.sp,
              modifier = Modifier.padding(end = 6.dp)
            )
            Text(
              text = "Email: ${ContactUtils.EMAIL_ADDRESS}",
              color = Slate100,
              fontSize = 12.sp,
              fontWeight = FontWeight.Medium
            )
          }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Free Demo Class Booking Trigger
        OutlinedButton(
          onClick = { onBookDemoClick() },
          shape = RoundedCornerShape(12.dp),
          border = BorderStroke(1.5.dp, BrandGoldBright),
          colors = ButtonDefaults.outlinedButtonColors(contentColor = BrandGoldBright),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
          ) {
            Text(text = "🎓", fontSize = 14.sp)
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "Book A Free Doorstep Demo Class",
              color = BrandGoldBright,
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold
            )
          }
        }
      }
    }
  }
}

/**
 * Trust Tagline and Footer Branding
 */
@Composable
fun FlyerFooterSection(
  onShareClick: () -> Unit = {}
) {
  val context = LocalContext.current

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(Slate900)
      .padding(horizontal = 16.dp, vertical = 18.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      text = "“Your Child’s Success Starts With the Right Guidance!”",
      color = BrandGoldBright,
      fontSize = 14.sp,
      fontWeight = FontWeight.Bold,
      textAlign = TextAlign.Center,
      lineHeight = 20.sp
    )

    Spacer(modifier = Modifier.height(10.dp))

    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(1.dp)
        .background(Slate800)
    )

    Spacer(modifier = Modifier.height(10.dp))

    // 3 Trust Badges: Safe Home Tutoring, Flexible Timings, Free Demo Class Available
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceEvenly,
      verticalAlignment = Alignment.CenterVertically
    ) {
      TrustBadge(text = "Safe Home Tutoring")
      Text(text = "•", color = Slate600, fontSize = 12.sp)
      TrustBadge(text = "Flexible Timings")
      Text(text = "•", color = Slate600, fontSize = 12.sp)
      TrustBadge(text = "Free Demo Class")
    }

    Spacer(modifier = Modifier.height(14.dp))

    // Share & Copyright bar
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = "© LUCKY TUITIONS ACADEMY • SERVING QUALITY EDUCATION",
        color = Slate600,
        fontSize = 9.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.5.sp
      )

      Row(
        modifier = Modifier
          .clip(RoundedCornerShape(6.dp))
          .clickable { ContactUtils.shareFlyer(context) }
          .padding(horizontal = 6.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Icon(
          imageVector = Icons.Default.Share,
          contentDescription = "Share",
          tint = BrandGoldBright,
          modifier = Modifier.size(14.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = "Share",
          color = BrandGoldBright,
          fontSize = 10.sp,
          fontWeight = FontWeight.Bold
        )
      }
    }
  }
}

@Composable
private fun TrustBadge(text: String) {
  Row(
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      text = "✔",
      color = BrandEmerald,
      fontSize = 11.sp,
      fontWeight = FontWeight.Bold,
      modifier = Modifier.padding(end = 4.dp)
    )
    Text(
      text = text,
      color = Slate300,
      fontSize = 11.sp,
      fontWeight = FontWeight.Medium
    )
  }
}

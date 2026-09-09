package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.CurriculumOffer
import com.example.model.SampleData
import com.example.model.TutorProfile
import com.example.ui.theme.BrandEmerald
import com.example.ui.theme.BrandEmeraldDark
import com.example.ui.theme.BrandEmeraldLight
import com.example.ui.theme.BrandGold
import com.example.ui.theme.BrandGoldBright
import com.example.ui.theme.BrandGoldLight
import com.example.ui.theme.BrandGoldSoft
import com.example.ui.theme.BrandNavy
import com.example.ui.theme.BrandNavyDark
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
 * Interactive Demo Class Booking Bottom Sheet
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun DemoBookingBottomSheet(
  initialGrade: String = "Class 10th",
  initialBoard: String = "CBSE",
  onDismiss: () -> Unit
) {
  val context = LocalContext.current
  val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

  var studentName by remember { mutableStateOf("") }
  var parentPhone by remember { mutableStateOf("") }
  var selectedClass by remember { mutableStateOf(initialGrade) }
  var selectedBoard by remember { mutableStateOf(initialBoard) }
  var locality by remember { mutableStateOf("") }
  var preferredTime by remember { mutableStateOf("Evening (5 PM - 7 PM)") }
  var isBooked by remember { mutableStateOf(false) }

  val classOptions = listOf("Class 1-5", "Class 6-8", "Class 9-10", "Inter 1st Year", "Inter 2nd Year")
  val boardOptions = listOf("CBSE", "State Board", "ICSE")
  val timeOptions = listOf("Morning (8 AM - 10 AM)", "Evening (5 PM - 7 PM)", "Evening (7 PM - 9 PM)", "Weekends")

  val subjectOptions = listOf("Maths", "Science / Physics", "Chemistry", "Biology", "English", "Commerce", "All Subjects")
  var selectedSubjects by remember { mutableStateOf(setOf("Maths", "Science / Physics")) }

  ModalBottomSheet(
    onDismissRequest = onDismiss,
    sheetState = sheetState,
    containerColor = Color.White,
    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(rememberScrollState())
        .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {
      if (!isBooked) {
        // Form Title
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Column {
            Text(
              text = "Book A Free Demo Class",
              color = BrandNavy,
              fontSize = 20.sp,
              fontWeight = FontWeight.Bold
            )
            Text(
              text = "Experience our 1-on-1 personalized home tutoring",
              color = Slate600,
              fontSize = 12.sp
            )
          }
          IconButton(onClick = onDismiss) {
            Icon(Icons.Default.Close, contentDescription = "Close", tint = Slate700)
          }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Student Name
        OutlinedTextField(
          value = studentName,
          onValueChange = { studentName = it },
          label = { Text("Student Name") },
          placeholder = { Text("e.g. Rahul Sharma") },
          singleLine = true,
          modifier = Modifier.fillMaxWidth(),
          colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = BrandNavy,
            focusedLabelColor = BrandNavy
          ),
          shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Parent Phone Number
        OutlinedTextField(
          value = parentPhone,
          onValueChange = { parentPhone = it },
          label = { Text("Parent / Contact Phone Number") },
          placeholder = { Text("e.g. 9876543210") },
          singleLine = true,
          modifier = Modifier.fillMaxWidth(),
          colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = BrandNavy,
            focusedLabelColor = BrandNavy
          ),
          shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))

        // Class/Grade Selector
        Text(
          text = "Select Class / Grade",
          color = BrandNavy,
          fontSize = 13.sp,
          fontWeight = FontWeight.Bold
        )
        FlowRow(
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          modifier = Modifier.padding(top = 6.dp)
        ) {
          classOptions.forEach { grade ->
            FilterChip(
              selected = selectedClass == grade,
              onClick = { selectedClass = grade },
              label = { Text(grade, fontSize = 11.sp, fontWeight = FontWeight.SemiBold) },
              colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = BrandNavy,
                selectedLabelColor = Color.White
              ),
              shape = RoundedCornerShape(9999.dp)
            )
          }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Board Selector
        Text(
          text = "Curriculum / Board",
          color = BrandNavy,
          fontSize = 13.sp,
          fontWeight = FontWeight.Bold
        )
        Row(
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          modifier = Modifier.padding(top = 6.dp)
        ) {
          boardOptions.forEach { board ->
            FilterChip(
              selected = selectedBoard == board,
              onClick = { selectedBoard = board },
              label = { Text(board, fontSize = 11.sp, fontWeight = FontWeight.SemiBold) },
              colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = BrandEmerald,
                selectedLabelColor = Color.White
              ),
              shape = RoundedCornerShape(9999.dp)
            )
          }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Subjects Required
        Text(
          text = "Subjects Required",
          color = BrandNavy,
          fontSize = 13.sp,
          fontWeight = FontWeight.Bold
        )
        FlowRow(
          horizontalArrangement = Arrangement.spacedBy(6.dp),
          modifier = Modifier.padding(top = 6.dp)
        ) {
          subjectOptions.forEach { subject ->
            val isSelected = selectedSubjects.contains(subject)
            FilterChip(
              selected = isSelected,
              onClick = {
                selectedSubjects = if (isSelected) {
                  selectedSubjects - subject
                } else {
                  selectedSubjects + subject
                }
              },
              label = { Text(subject, fontSize = 11.sp) },
              colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = BrandGoldBright,
                selectedLabelColor = BrandNavyDark
              ),
              shape = RoundedCornerShape(8.dp)
            )
          }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Locality / Area
        OutlinedTextField(
          value = locality,
          onValueChange = { locality = it },
          label = { Text("Locality / Colony Area") },
          placeholder = { Text("e.g. Madhapur / KPHB / Banjara Hills") },
          singleLine = true,
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Preferred Timing
        Text(
          text = "Preferred Timing Slot",
          color = BrandNavy,
          fontSize = 13.sp,
          fontWeight = FontWeight.Bold
        )
        FlowRow(
          horizontalArrangement = Arrangement.spacedBy(6.dp),
          modifier = Modifier.padding(top = 6.dp)
        ) {
          timeOptions.forEach { time ->
            FilterChip(
              selected = preferredTime == time,
              onClick = { preferredTime = time },
              label = { Text(time, fontSize = 11.sp) },
              shape = RoundedCornerShape(8.dp)
            )
          }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Submit Button
        Button(
          onClick = {
            isBooked = true
          },
          colors = ButtonDefaults.buttonColors(containerColor = BrandEmerald),
          shape = RoundedCornerShape(12.dp),
          modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
        ) {
          Text(
            text = "Request Free Demo Session",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
          )
        }
      } else {
        // Confirmation Screen
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Box(
            modifier = Modifier
              .size(60.dp)
              .clip(CircleShape)
              .background(BrandEmeraldLight),
            contentAlignment = Alignment.Center
          ) {
            Text(text = "🎉", fontSize = 30.sp)
          }

          Spacer(modifier = Modifier.height(12.dp))

          Text(
            text = "Demo Class Request Received!",
            color = BrandNavy,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
          )

          Text(
            text = "Reference #LT-${(1000..9999).random()}",
            color = BrandGold,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 4.dp)
          )

          Spacer(modifier = Modifier.height(14.dp))

          Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Slate50),
            border = BorderStroke(1.dp, Slate200),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(
              modifier = Modifier.padding(14.dp),
              verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
              InfoRow(label = "Student", value = if (studentName.isNotBlank()) studentName else "Student")
              InfoRow(label = "Class & Board", value = "$selectedClass ($selectedBoard)")
              InfoRow(label = "Subjects", value = selectedSubjects.joinToString(", "))
              InfoRow(label = "Preferred Slot", value = preferredTime)
              if (locality.isNotBlank()) {
                InfoRow(label = "Locality", value = locality)
              }
              InfoRow(label = "Tutor Coordinator", value = "Lucky Tuitions Desk (8520990880)")
            }
          }

          Spacer(modifier = Modifier.height(16.dp))

          // Action 1: Send on WhatsApp
          val whatsappMsg = "Hello Lucky Tuitions, I requested a free demo class for student: ${if (studentName.isNotBlank()) studentName else "Student"}, Class: $selectedClass ($selectedBoard), Subjects: ${selectedSubjects.joinToString(", ")}, Timing: $preferredTime, Contact: $parentPhone. Please coordinate tutor."
          Button(
            onClick = {
              ContactUtils.openWhatsApp(context, whatsappMsg)
              onDismiss()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF22C55E)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
              .fillMaxWidth()
              .height(48.dp)
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.Center
            ) {
              Text(text = "💬", fontSize = 16.sp)
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = "Send Details on WhatsApp to Coordinator",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = Color.White
              )
            }
          }

          Spacer(modifier = Modifier.height(8.dp))

          // Action 2: Call Coordinator Desk
          OutlinedButton(
            onClick = {
              ContactUtils.dialDesk(context)
              onDismiss()
            },
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.5.dp, BrandNavy),
            modifier = Modifier
              .fillMaxWidth()
              .height(48.dp)
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.Center
            ) {
              Icon(Icons.Default.Call, contentDescription = null, tint = BrandNavy, modifier = Modifier.size(16.dp))
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = "Call Coordinator Directly (8520990880)",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = BrandNavy
              )
            }
          }

          Spacer(modifier = Modifier.height(8.dp))

          Text(
            text = "Our verified tutor coordinator will contact you within 2 hours to confirm your tutor match.",
            color = Slate600,
            fontSize = 11.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 8.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(24.dp))
    }
  }
}

@Composable
private fun InfoRow(label: String, value: String) {
  Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    Text(text = label, color = Slate600, fontSize = 12.sp)
    Text(
      text = value,
      color = BrandNavy,
      fontSize = 12.sp,
      fontWeight = FontWeight.SemiBold,
      textAlign = TextAlign.End,
      modifier = Modifier.width(180.dp)
    )
  }
}

/**
 * Curriculum Detail Bottom Sheet
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurriculumDetailBottomSheet(
  offer: CurriculumOffer,
  onDismiss: () -> Unit,
  onRequestTutor: (CurriculumOffer) -> Unit
) {
  val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

  ModalBottomSheet(
    onDismissRequest = onDismiss,
    sheetState = sheetState,
    containerColor = Color.White,
    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(rememberScrollState())
        .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Text(text = offer.iconEmoji, fontSize = 28.sp, modifier = Modifier.padding(end = 10.dp))
          Column {
            Text(text = offer.title, color = BrandNavy, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = offer.subtitle, color = BrandGold, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
          }
        }
        IconButton(onClick = onDismiss) {
          Icon(Icons.Default.Close, contentDescription = "Close")
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      Text(text = offer.description, color = Slate700, fontSize = 13.sp, lineHeight = 20.sp)

      Spacer(modifier = Modifier.height(16.dp))

      Text(text = "Key Subjects Covered", color = BrandNavy, fontSize = 14.sp, fontWeight = FontWeight.Bold)
      Spacer(modifier = Modifier.height(6.dp))
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Slate50),
        border = BorderStroke(1.dp, Slate200),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
          offer.subjects.forEach { subject ->
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text(text = "•", color = BrandEmerald, fontSize = 14.sp, modifier = Modifier.padding(end = 8.dp))
              Text(text = subject, color = Slate800, fontSize = 12.sp, fontWeight = FontWeight.Medium)
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      Text(text = "Teaching Methodology & Benefits", color = BrandNavy, fontSize = 14.sp, fontWeight = FontWeight.Bold)
      Spacer(modifier = Modifier.height(6.dp))
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Slate50),
        border = BorderStroke(1.dp, Slate200),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
          offer.highlights.forEach { item ->
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text(text = "✔", color = BrandEmerald, fontSize = 12.sp, modifier = Modifier.padding(end = 8.dp))
              Text(text = item, color = Slate800, fontSize = 12.sp)
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(20.dp))

      Button(
        onClick = {
          onDismiss()
          onRequestTutor(offer)
        },
        colors = ButtonDefaults.buttonColors(containerColor = BrandEmerald),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
          .fillMaxWidth()
          .height(48.dp)
      ) {
        Text(
          text = "Book Tutor for ${offer.title}",
          fontSize = 14.sp,
          fontWeight = FontWeight.Bold,
          color = Color.White
        )
      }

      Spacer(modifier = Modifier.height(24.dp))
    }
  }
}

/**
 * Fee & Slot Calculator Bottom Sheet
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeeCalculatorBottomSheet(
  onDismiss: () -> Unit,
  onBookNow: () -> Unit
) {
  val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

  var selectedGradeTier by remember { mutableStateOf("Class 9-10") }
  var selectedDaysPerWeek by remember { mutableStateOf(5) }
  var isPersonalOneOnOne by remember { mutableStateOf(true) }

  // Calculation heuristic
  val baseRatePerMonth = when (selectedGradeTier) {
    "Class 1-5" -> 3500
    "Class 6-8" -> 4500
    "Class 9-10" -> 6000
    else -> 8000 // Intermediate (+1 & +2)
  }

  val dayMultiplier = when (selectedDaysPerWeek) {
    3 -> 0.75f
    5 -> 1.0f
    else -> 1.2f
  }

  val formatMultiplier = if (isPersonalOneOnOne) 1.0f else 0.65f
  val estimatedMonthlyFee = (baseRatePerMonth * dayMultiplier * formatMultiplier).toInt()

  ModalBottomSheet(
    onDismissRequest = onDismiss,
    sheetState = sheetState,
    containerColor = Color.White,
    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(rememberScrollState())
        .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column {
          Text(text = "Tuition Fee & Slot Planner", color = BrandNavy, fontSize = 20.sp, fontWeight = FontWeight.Bold)
          Text(text = "Transparent estimated plans for doorstep home tutoring", color = Slate600, fontSize = 12.sp)
        }
        IconButton(onClick = onDismiss) {
          Icon(Icons.Default.Close, contentDescription = "Close")
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      Text(text = "1. Select Class Level", color = BrandNavy, fontSize = 13.sp, fontWeight = FontWeight.Bold)
      Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(top = 6.dp)
      ) {
        listOf("Class 1-5", "Class 6-8", "Class 9-10", "Inter +1/+2").forEach { tier ->
          FilterChip(
            selected = selectedGradeTier == tier,
            onClick = { selectedGradeTier = tier },
            label = { Text(tier, fontSize = 11.sp) },
            colors = FilterChipDefaults.filterChipColors(
              selectedContainerColor = BrandNavy,
              selectedLabelColor = Color.White
            ),
            shape = RoundedCornerShape(9999.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      Text(text = "2. Coaching Format", color = BrandNavy, fontSize = 13.sp, fontWeight = FontWeight.Bold)
      Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(top = 6.dp)
      ) {
        FilterChip(
          selected = isPersonalOneOnOne,
          onClick = { isPersonalOneOnOne = true },
          label = { Text("🎯 1-on-1 Dedicated Home Tutor", fontSize = 11.sp, fontWeight = FontWeight.SemiBold) },
          colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = BrandEmerald,
            selectedLabelColor = Color.White
          ),
          shape = RoundedCornerShape(9999.dp)
        )
        FilterChip(
          selected = !isPersonalOneOnOne,
          onClick = { isPersonalOneOnOne = false },
          label = { Text("👥 Small Batch (2-3 Students)", fontSize = 11.sp) },
          shape = RoundedCornerShape(9999.dp)
        )
      }

      Spacer(modifier = Modifier.height(14.dp))

      Text(text = "3. Sessions per Week", color = BrandNavy, fontSize = 13.sp, fontWeight = FontWeight.Bold)
      Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(top = 6.dp)
      ) {
        listOf(3 to "3 Days/Week", 5 to "5 Days/Week (Mon-Fri)", 6 to "6 Days/Week").forEach { (days, label) ->
          FilterChip(
            selected = selectedDaysPerWeek == days,
            onClick = { selectedDaysPerWeek = days },
            label = { Text(label, fontSize = 11.sp) },
            shape = RoundedCornerShape(9999.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(18.dp))

      // Estimated Result Card
      Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = BrandNavy),
        border = BorderStroke(2.dp, BrandGold),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(
          modifier = Modifier.padding(16.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(text = "ESTIMATED TUITION FEE GUIDE", color = BrandGoldBright, fontSize = 11.sp, fontWeight = FontWeight.Bold)
          Spacer(modifier = Modifier.height(6.dp))
          Row(verticalAlignment = Alignment.Bottom) {
            Text(text = "₹$estimatedMonthlyFee", color = Color.White, fontSize = 32.sp, fontWeight = FontWeight.Black)
            Text(text = " / month", color = Slate300, fontSize = 14.sp, modifier = Modifier.padding(bottom = 4.dp))
          }

          Spacer(modifier = Modifier.height(10.dp))
          Text(
            text = "Includes: Daily Doorstep Sessions (1-1.5 hrs), Weekly Chapter Mock Tests, Monthly Progress Report for Parents, and Direct Doubt-Clearing.",
            color = Slate200,
            fontSize = 11.sp,
            textAlign = TextAlign.Center,
            lineHeight = 16.sp
          )
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      Button(
        onClick = {
          onDismiss()
          onBookNow()
        },
        colors = ButtonDefaults.buttonColors(containerColor = BrandEmerald),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
          .fillMaxWidth()
          .height(48.dp)
      ) {
        Text(text = "Book Free Demo for this Plan", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.White)
      }

      Spacer(modifier = Modifier.height(24.dp))
    }
  }
}

/**
 * Verified Tutors Bottom Sheet
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerifiedTutorsBottomSheet(
  tutors: List<TutorProfile> = SampleData.tutorProfiles,
  onDismiss: () -> Unit,
  onSelectTutor: (TutorProfile) -> Unit
) {
  val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

  ModalBottomSheet(
    onDismissRequest = onDismiss,
    sheetState = sheetState,
    containerColor = Color.White,
    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(rememberScrollState())
        .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column {
          Text(text = "Verified Subject Faculty", color = BrandNavy, fontSize = 20.sp, fontWeight = FontWeight.Bold)
          Text(text = "Background checked, experienced educators at your doorstep", color = Slate600, fontSize = 12.sp)
        }
        IconButton(onClick = onDismiss) {
          Icon(Icons.Default.Close, contentDescription = "Close")
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        tutors.forEach { tutor ->
          Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Slate50),
            border = BorderStroke(1.dp, Slate200),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Column {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = tutor.name, color = BrandNavy, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(6.dp))
                    Surface(shape = RoundedCornerShape(9999.dp), color = BrandEmeraldLight) {
                      Text(
                        text = "✔ Verified",
                        color = BrandEmerald,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                      )
                    }
                  }
                  Text(text = tutor.title, color = BrandGold, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text(text = "⭐", fontSize = 12.sp)
                  Spacer(modifier = Modifier.width(2.dp))
                  Text(text = "${tutor.rating}", color = Slate800, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                  Text(text = " (${tutor.reviewsCount})", color = Slate600, fontSize = 10.sp)
                }
              }

              Spacer(modifier = Modifier.height(8.dp))

              Text(text = "🎓 ${tutor.qualification} • ⏳ ${tutor.experience}", color = Slate700, fontSize = 11.sp)
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "Subjects: ${tutor.subjects.joinToString(", ")}",
                color = Slate600,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium
              )

              Spacer(modifier = Modifier.height(10.dp))

              Button(
                onClick = {
                  onDismiss()
                  onSelectTutor(tutor)
                },
                colors = ButtonDefaults.buttonColors(containerColor = BrandNavy),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                  .fillMaxWidth()
                  .height(36.dp)
              ) {
                Text(text = "Request Demo with ${tutor.name.split(" ").first()}", fontSize = 12.sp, color = Color.White)
              }
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(24.dp))
    }
  }
}

package com.example.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

object ContactUtils {
  const val PHONE_NUMBER = "8520990880"
  const val WHATSAPP_NUMBER = "918520990880"
  const val EMAIL_ADDRESS = "bhukyavinay304@gmail.com"

  fun dialDesk(context: Context) {
    try {
      val intent = Intent(Intent.ACTION_DIAL).apply {
        data = Uri.parse("tel:$PHONE_NUMBER")
      }
      context.startActivity(intent)
    } catch (e: Exception) {
      Toast.makeText(context, "Could not open dialer: $PHONE_NUMBER", Toast.LENGTH_SHORT).show()
    }
  }

  fun openWhatsApp(
    context: Context,
    message: String = "Hello Lucky Tuitions, I am interested in home tuitions for my child."
  ) {
    try {
      val encodedMsg = Uri.encode(message)
      val url = "https://wa.me/$WHATSAPP_NUMBER?text=$encodedMsg"
      val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
      context.startActivity(intent)
    } catch (e: Exception) {
      Toast.makeText(context, "Unable to open WhatsApp. Contact: $PHONE_NUMBER", Toast.LENGTH_SHORT).show()
    }
  }

  fun sendEmail(
    context: Context,
    subject: String = "Inquiry for Lucky Tuitions Home Coaching",
    body: String = "Hello Lucky Tuitions team,\n\nI would like to inquire about home tutoring services for my child.\n\nThank you."
  ) {
    try {
      val intent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:$EMAIL_ADDRESS")
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, body)
      }
      context.startActivity(intent)
    } catch (e: Exception) {
      Toast.makeText(context, "Contact: $EMAIL_ADDRESS", Toast.LENGTH_SHORT).show()
    }
  }

  fun shareFlyer(context: Context) {
    try {
      val shareText = """
        🌟 LUCKY TUITIONS 🌟
        Premier Home & Personal Coaching Academy
        📚 Home Tuitions for All Classes!
        
        • CBSE Syllabus (1st to 10th - All Subjects)
        • State Syllabus (All Boards & Mediums)
        • Intermediate / +1 & +2 (MPC • BiPC • Commerce)
        • All Core Subjects: Maths, Science, Physics, Chem, Eng
        
        ✨ Experienced & Verified Tutors at Your Doorstep
        ⭐ Concept-Based Learning • Weekly Tests • 1-on-1 Focus
        
        📞 Contact Tutor Coordination Desk: 8520990880
        💬 WhatsApp: https://wa.me/$WHATSAPP_NUMBER
        📧 Email: $EMAIL_ADDRESS
      """.trimIndent()

      val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, "Lucky Tuitions - Premier Home Coaching")
        putExtra(Intent.EXTRA_TEXT, shareText)
      }
      context.startActivity(Intent.createChooser(intent, "Share Lucky Tuitions"))
    } catch (e: Exception) {
      Toast.makeText(context, "Unable to share", Toast.LENGTH_SHORT).show()
    }
  }
}

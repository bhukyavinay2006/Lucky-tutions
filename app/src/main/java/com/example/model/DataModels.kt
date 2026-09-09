package com.example.model

data class CurriculumOffer(
  val id: String,
  val title: String,
  val subtitle: String,
  val iconEmoji: String,
  val description: String,
  val targetGrades: String,
  val subjects: List<String>,
  val highlights: List<String>
)

data class TutorProfile(
  val id: String,
  val name: String,
  val title: String,
  val qualification: String,
  val experience: String,
  val subjects: List<String>,
  val rating: Float,
  val reviewsCount: Int,
  val verifiedBadge: Boolean = true
)

data class DemoBooking(
  val studentName: String = "",
  val parentPhone: String = "",
  val studentClass: String = "Class 10th",
  val board: String = "CBSE",
  val subjects: List<String> = emptyList(),
  val locality: String = "",
  val preferredTiming: String = "Evening (5 PM - 7 PM)"
)

object SampleData {
  val curriculumList = listOf(
    CurriculumOffer(
      id = "cbse",
      title = "CBSE Syllabus",
      subtitle = "Class 1st to Class 10th (All Subjects)",
      iconEmoji = "🏫",
      description = "Comprehensive NCERT-aligned coaching focusing on fundamentals, continuous school assessments, and board exam mastery.",
      targetGrades = "Classes 1 to 10",
      subjects = listOf("Mathematics", "Science (Phy/Chem/Bio)", "English", "Social Science", "Hindi"),
      highlights = listOf(
        "NCERT exemplar question solving",
        "Step-by-step problem-solving methods",
        "Weekly chapter-end test series",
        "CBSE sample papers & past 5 years papers"
      )
    ),
    CurriculumOffer(
      id = "state",
      title = "State Syllabus",
      subtitle = "All State Boards & Mediums",
      iconEmoji = "📖",
      description = "Complete syllabus coverage for State Board curriculum with bilingual explanations, textbook mastery, and exam score boosting.",
      targetGrades = "Classes 1 to 10",
      subjects = listOf("Mathematics", "General Science", "Social Studies", "First & Second Languages", "English"),
      highlights = listOf(
        "Thorough textbook question coverage",
        "Clear concept delivery in English & Regional medium",
        "Targeted preparation for quarterly & half-yearly exams",
        "Handwritten notes and formula sheets provided"
      )
    ),
    CurriculumOffer(
      id = "intermediate",
      title = "Intermediate / +1 & +2",
      subtitle = "MPC • BiPC • Commerce",
      iconEmoji = "🎓",
      description = "Rigorous coaching for 11th & 12th standard covering board examinations alongside competitive foundation prep (JEE, NEET, EAPCET).",
      targetGrades = "1st & 2nd Year (+1 & +2)",
      subjects = listOf("Maths 1A/1B & 2A/2B", "Physics", "Chemistry", "Botany & Zoology", "Economics & Accountancy"),
      highlights = listOf(
        "Derivations & numericals practice",
        "Previous board question banks (IPE / State / CBSE 12)",
        "Daily doubt resolution & assignment tracking",
        "Shortcut calculation techniques for entrance exams"
      )
    ),
    CurriculumOffer(
      id = "core_subjects",
      title = "All Core Subjects",
      subtitle = "Maths, Science, Physics, Chem, Eng",
      iconEmoji = "🔬",
      description = "Dedicated subject-specific mentoring by specialized faculty who simplify tough formulas, reactions, and grammar rules.",
      targetGrades = "All Grades (1st to 12th)",
      subjects = listOf("Mathematics & Arithmetic", "Physics & Mechanics", "Chemistry (Organic/Inorganic)", "Biology & Diagrams", "English Grammar & Writing"),
      highlights = listOf(
        "Targeted remediation in student's weak areas",
        "Mind maps & summary cheat-sheets",
        "One-on-one personal pace without rush",
        "Regular parent progress feedback"
      )
    )
  )

  val tutorProfiles = listOf(
    TutorProfile(
      id = "1",
      name = "Suresh Sharma",
      title = "Senior Mathematics Faculty",
      qualification = "M.Sc Mathematics, B.Ed",
      experience = "9+ Years Teaching Experience",
      subjects = listOf("Class 9-10 Maths", "Inter 1A/1B/2A/2B", "JEE Foundation"),
      rating = 4.9f,
      reviewsCount = 48
    ),
    TutorProfile(
      id = "2",
      name = "Dr. Ananya Reddy",
      title = "Science & Physics Specialist",
      qualification = "M.Sc Physics, Ph.D",
      experience = "7+ Years Teaching Experience",
      subjects = listOf("Class 8-10 Science", "Inter Physics", "NEET Basics"),
      rating = 5.0f,
      reviewsCount = 36
    ),
    TutorProfile(
      id = "3",
      name = "Kavitha Raman",
      title = "Primary & Middle School Foundation Mentor",
      qualification = "M.A English, B.Ed",
      experience = "8+ Years Dedicated Tutoring",
      subjects = listOf("Classes 1 to 7 (All Subjects)", "English Grammar", "Basic Maths"),
      rating = 4.9f,
      reviewsCount = 52
    ),
    TutorProfile(
      id = "4",
      name = "Ravi Teja",
      title = "Chemistry & Organic Specialist",
      qualification = "M.Sc Organic Chemistry",
      experience = "6+ Years Specialized Coaching",
      subjects = listOf("Class 10 Chemistry", "Inter Chemistry (MPC/BiPC)", "Formula Mastery"),
      rating = 4.8f,
      reviewsCount = 29
    )
  )

  val parentReviews = listOf(
    "My son was struggling in 10th CBSE Mathematics. After Lucky Tuitions assigned Sir Suresh, his marks improved from 54% to 91% in his pre-boards!" to "Sunita Rao, Parent (Class 10)",
    "The 1-on-1 personal attention at our doorstep made a world of difference. Very disciplined, punctual, and patient tutors." to "Venkatesh K., Parent (Class 8)",
    "Excellent guidance for Intermediate MPC. The tutor focused on previous question papers and made complex Physics derivations so simple." to "Pooja Varma, Parent (Inter 2nd Year)"
  )
}

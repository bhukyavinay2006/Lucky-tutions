import React, { useState } from 'react';
import {
  Phone,
  MessageCircle,
  GraduationCap,
  BookOpen,
  CheckCircle2,
  Star,
  Sparkles,
  Calculator,
  Calendar,
  Clock,
  MapPin,
  User,
  ShieldCheck,
  Award,
  Send,
  X,
  Check
} from 'lucide-react';

interface CurriculumItem {
  id: string;
  title: string;
  subtitle: string;
  badge: string;
  description: string;
  subjects: string[];
  highlights: string[];
}

const CURRICULA: CurriculumItem[] = [
  {
    id: 'cbse',
    title: 'CBSE Syllabus',
    subtitle: 'Class 1st to Class 10th (All Subjects)',
    badge: 'NCERT Aligned',
    description: 'Structured, concept-first coaching following the latest CBSE academic patterns with comprehensive NCERT problem solving and regular board question practice.',
    subjects: ['Mathematics', 'Science (Phy/Chem/Bio)', 'English Literature & Grammar', 'Social Science', 'Hindi / Regional'],
    highlights: [
      'In-depth NCERT exemplar & textbook question mastery',
      'Step-by-step problem-solving technique for higher marks',
      'Weekly unit tests & chapter-wise evaluation series',
      'Past 5 years CBSE board question paper simulations'
    ]
  },
  {
    id: 'state',
    title: 'State Syllabus',
    subtitle: 'All State Boards & Mediums',
    badge: 'Bilingual Support',
    description: 'Rigorous state board textbook coverage with bilingual explanations (English + Telugu/Hindi) designed to build rock-solid foundational concepts and boost examination scores.',
    subjects: ['Mathematics & Arithmetic', 'General Science', 'Social Studies', 'First & Second Languages', 'English'],
    highlights: [
      'Line-by-line textbook analysis and solution building',
      'Bilingual explanation for intuitive concept clarity',
      'Targeted revision sessions for quarterly & half-yearly exams',
      'Handcrafted formula booklets & chapter memory maps'
    ]
  },
  {
    id: 'intermediate',
    title: 'Intermediate / +1 & +2',
    subtitle: 'MPC • BiPC • Commerce Streams',
    badge: 'Board + Foundations',
    description: 'Specialized faculty for 11th & 12th standards providing intensive board examination drill alongside competitive foundation problem-solving.',
    subjects: ['Mathematics 1A/1B & 2A/2B', 'Physics (Mechanics/Electrodynamics)', 'Chemistry (Organic/Inorganic)', 'Botany & Zoology', 'Economics & Accountancy'],
    highlights: [
      'Derivations, formula blueprints & high-weightage numericals',
      'Chapter-wise previous 10-year question bank drills',
      'Daily 1-on-1 doubt clearing & homework guidance',
      'Speed calculation tricks for competitive exam readiness'
    ]
  },
  {
    id: 'core_subjects',
    title: 'All Core Subjects',
    subtitle: 'Maths, Science, Physics, Chemistry, English',
    badge: 'Individual Focus',
    description: 'Dedicated subject-specialist mentors who demystify tricky theorems, complex chemical equations, and foundational grammatical structures at your child’s comfortable pace.',
    subjects: ['Pure Mathematics & Geometry', 'Applied Physics', 'Chemical Reactions & Stoichiometry', 'Biology Diagrams & Concepts', 'Advanced English Composition'],
    highlights: [
      'Diagnostic assessment to target specific learning gaps',
      'Personalized pace with zero peer pressure',
      'Regular parent-tutor review calls & progress scorecards',
      'Proven score improvement within 30 days of guidance'
    ]
  }
];

const WHY_CHOOSE_US = [
  {
    title: 'Experienced & Verified Tutors',
    desc: 'Carefully vetted mentors with 5+ years of teaching expertise and proven academic excellence.',
    icon: Award
  },
  {
    title: '1-on-1 Doorstep Home Coaching',
    desc: 'Personalized private attention in the safe, comfortable environment of your own home.',
    icon: ShieldCheck
  },
  {
    title: 'Weekly Tests & Performance Logs',
    desc: 'Systematic testing after each chapter with transparent feedback reports delivered to parents.',
    icon: CheckCircle2
  },
  {
    title: 'Doubt Clearing & Exam Strategy',
    desc: 'Unrushed sessions ensuring zero backlog and complete conceptual clarity before exam season.',
    icon: Sparkles
  }
];

export default function App() {
  const [activeCurriculum, setActiveCurriculum] = useState<string>('cbse');
  const [showBookingModal, setShowBookingModal] = useState<boolean>(false);
  const [showFeeCalculator, setShowFeeCalculator] = useState<boolean>(false);
  const [bookingSuccess, setBookingSuccess] = useState<boolean>(false);

  // Booking Form State
  const [studentName, setStudentName] = useState('');
  const [parentPhone, setParentPhone] = useState('');
  const [studentGrade, setStudentGrade] = useState('Class 10th');
  const [boardType, setBoardType] = useState('CBSE');
  const [locality, setLocality] = useState('');
  const [timing, setTiming] = useState('Evening (5:00 PM - 7:00 PM)');

  // Calculator State
  const [calcGrade, setCalcGrade] = useState<'primary' | 'middle' | 'high' | 'inter'>('high');
  const [calcDays, setCalcDays] = useState<number>(5);
  const [calcSubjects, setCalcSubjects] = useState<number>(2);

  const calculateEstimatedFee = () => {
    let basePerSubject = 1800;
    if (calcGrade === 'primary') basePerSubject = 1200;
    else if (calcGrade === 'middle') basePerSubject = 1500;
    else if (calcGrade === 'high') basePerSubject = 2000;
    else if (calcGrade === 'inter') basePerSubject = 2800;

    const daysFactor = calcDays === 6 ? 1.15 : calcDays === 5 ? 1.0 : 0.85;
    return Math.round(basePerSubject * calcSubjects * daysFactor);
  };

  const handleBookingSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (!studentName || !parentPhone) return;
    setBookingSuccess(true);
    setTimeout(() => {
      setBookingSuccess(false);
      setShowBookingModal(false);
      setStudentName('');
      setParentPhone('');
      setLocality('');
    }, 2500);
  };

  const currentCurriculum = CURRICULA.find(c => c.id === activeCurriculum) || CURRICULA[0];

  return (
    <div className="min-h-screen bg-slate-950 text-slate-100 flex flex-col selection:bg-amber-400 selection:text-slate-900">
      {/* Top Notification / Quality Ticker */}
      <header id="top-announcement" className="bg-gradient-to-r from-amber-600 via-amber-500 to-amber-600 text-slate-950 text-xs sm:text-sm font-semibold py-1.5 px-4 text-center tracking-wide shadow-sm flex items-center justify-center gap-2">
        <Sparkles className="w-4 h-4 shrink-0 text-slate-950" />
        <span>Quality Education • Personal Attention • Better Results</span>
      </header>

      {/* Main Navigation / Brand Bar */}
      <nav id="navbar" className="bg-slate-900/90 backdrop-blur-md border-b border-slate-800 sticky top-0 z-40 px-4 sm:px-6 lg:px-8 py-3.5 transition-all">
        <div className="max-w-7xl mx-auto flex items-center justify-between">
          <div className="flex items-center gap-3">
            <div className="w-10 h-10 rounded-xl bg-gradient-to-br from-amber-400 to-amber-600 flex items-center justify-center shadow-lg shadow-amber-500/20 text-slate-950 font-black text-xl">
              LT
            </div>
            <div>
              <div className="flex items-center gap-1.5">
                <span className="font-extrabold tracking-wider text-xl sm:text-2xl text-transparent bg-clip-text bg-gradient-to-r from-amber-300 via-amber-400 to-yellow-200">
                  LUCKY TUITIONS
                </span>
                <span className="bg-emerald-500/20 text-emerald-400 text-[10px] font-bold px-1.5 py-0.5 rounded border border-emerald-500/30">
                  VERIFIED
                </span>
              </div>
              <p className="text-xs text-slate-400 font-medium">Home Tuitions for All Classes</p>
            </div>
          </div>

          <div className="flex items-center gap-3">
            <button
              id="nav-calc-btn"
              onClick={() => setShowFeeCalculator(true)}
              className="hidden sm:flex items-center gap-2 px-3.5 py-2 rounded-lg bg-slate-800 hover:bg-slate-700 text-slate-200 text-sm font-medium border border-slate-700 transition"
            >
              <Calculator className="w-4 h-4 text-amber-400" />
              <span>Fee Guide</span>
            </button>

            <button
              id="nav-demo-btn"
              onClick={() => setShowBookingModal(true)}
              className="flex items-center gap-2 px-4 py-2 rounded-lg bg-gradient-to-r from-amber-400 to-amber-500 hover:from-amber-300 hover:to-amber-400 text-slate-950 font-bold text-sm shadow-md shadow-amber-500/20 transition transform active:scale-95"
            >
              <Calendar className="w-4 h-4" />
              <span>Book Free Demo</span>
            </button>
          </div>
        </div>
      </nav>

      {/* Hero Section */}
      <section id="hero-section" className="relative overflow-hidden pt-8 pb-12 sm:pt-12 sm:pb-16 bg-gradient-to-b from-slate-900 via-slate-900/60 to-slate-950 border-b border-slate-800/80">
        <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 relative z-10">
          <div className="grid grid-cols-1 lg:grid-cols-12 gap-8 lg:gap-12 items-center">
            {/* Left Content */}
            <div className="lg:col-span-7 space-y-6 text-left">
              <div className="inline-flex items-center gap-2 px-3 py-1 rounded-full bg-amber-400/10 border border-amber-400/30 text-amber-400 text-xs font-semibold">
                <ShieldCheck className="w-3.5 h-3.5 text-amber-400" />
                <span>Premier Doorstep Home Tutoring Network</span>
              </div>

              <h1 className="text-3xl sm:text-5xl font-extrabold tracking-tight text-white leading-tight">
                Unlock Your Child's True Potential with{' '}
                <span className="text-transparent bg-clip-text bg-gradient-to-r from-amber-300 via-amber-400 to-yellow-200">
                  Personal 1-on-1 Coaching
                </span>
              </h1>

              <p className="text-slate-300 text-base sm:text-lg leading-relaxed max-w-2xl">
                Specialized home coaching for <strong className="text-white">CBSE</strong>, <strong className="text-white">State Board</strong>, and <strong className="text-white">Intermediate</strong> (+1 & +2). We match dedicated subject-matter tutors directly to your home with proven grade improvements.
              </p>

              {/* Action Buttons */}
              <div className="flex flex-wrap items-center gap-4 pt-2">
                <button
                  id="hero-demo-btn"
                  onClick={() => setShowBookingModal(true)}
                  className="px-6 py-3.5 rounded-xl bg-gradient-to-r from-amber-400 via-amber-500 to-yellow-500 hover:from-amber-300 hover:to-amber-400 text-slate-950 font-extrabold text-base shadow-lg shadow-amber-500/25 flex items-center gap-2.5 transition transform active:scale-95"
                >
                  <Calendar className="w-5 h-5 text-slate-950" />
                  <span>Schedule Free Demo Class</span>
                </button>

                <a
                  id="hero-call-btn"
                  href="tel:8520990880"
                  className="px-5 py-3.5 rounded-xl bg-slate-800/90 hover:bg-slate-700/90 text-white font-bold text-base border border-slate-700 flex items-center gap-2.5 transition"
                >
                  <Phone className="w-5 h-5 text-emerald-400" />
                  <span>Call 8520990880</span>
                </a>
              </div>

              {/* Social Proof Mini Stats */}
              <div className="grid grid-cols-3 gap-4 pt-4 border-t border-slate-800/80 max-w-lg">
                <div>
                  <div className="text-2xl font-black text-amber-400">98.4%</div>
                  <div className="text-xs text-slate-400">Exam Pass Rate</div>
                </div>
                <div>
                  <div className="text-2xl font-black text-emerald-400">500+</div>
                  <div className="text-xs text-slate-400">Students Coached</div>
                </div>
                <div>
                  <div className="text-2xl font-black text-blue-400">4.9 / 5</div>
                  <div className="text-xs text-slate-400">Parent Rating</div>
                </div>
              </div>
            </div>

            {/* Right Card / Flyer Visual */}
            <div className="lg:col-span-5">
              <div className="relative rounded-2xl overflow-hidden border-2 border-amber-500/30 shadow-2xl shadow-amber-500/10 bg-slate-900 group">
                <img
                  src="/tuition_hero.jpg"
                  alt="Lucky Tuitions Flyer"
                  className="w-full h-auto object-cover max-h-[460px] transition duration-500 group-hover:scale-105"
                  onError={(e) => {
                    // Fallback if image fails
                    (e.target as HTMLElement).style.display = 'none';
                  }}
                />
                <div className="absolute inset-0 bg-gradient-to-t from-slate-950 via-slate-950/20 to-transparent flex flex-col justify-end p-5">
                  <div className="flex items-center gap-2 mb-2">
                    <span className="bg-amber-400 text-slate-950 text-xs font-black px-2.5 py-1 rounded-md uppercase tracking-wider">
                      Admissions Open
                    </span>
                    <span className="bg-slate-900/80 text-slate-200 text-xs font-semibold px-2 py-1 rounded-md border border-slate-700">
                      All Localities Covered
                    </span>
                  </div>
                  <h3 className="text-lg font-bold text-white leading-snug">
                    Verified Home Tutors Dispatched to Your Doorstep
                  </h3>
                  <p className="text-xs text-slate-300 mt-1">
                    Daily 1-on-1 mentoring with continuous syllabus coverage and comprehensive exam drill.
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>

      {/* Curriculum Matrix Section */}
      <section id="curriculum-section" className="py-12 sm:py-16 max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 w-full">
        <div className="text-center max-w-3xl mx-auto mb-10">
          <h2 className="text-2xl sm:text-4xl font-extrabold text-white tracking-tight">
            Comprehensive Curriculum Offerings
          </h2>
          <p className="text-slate-400 text-sm sm:text-base mt-2">
            Tailored programs crafted specifically for individual student strengths and syllabus guidelines.
          </p>
        </div>

        {/* Curriculum Selector Tabs */}
        <div className="flex flex-wrap justify-center gap-2 sm:gap-3 mb-8">
          {CURRICULA.map((item) => {
            const isActive = activeCurriculum === item.id;
            return (
              <button
                key={item.id}
                id={`tab-${item.id}`}
                onClick={() => setActiveCurriculum(item.id)}
                className={`px-4 sm:px-5 py-2.5 rounded-xl font-bold text-sm sm:text-base transition-all flex items-center gap-2 ${
                  isActive
                    ? 'bg-amber-400 text-slate-950 shadow-lg shadow-amber-400/20 scale-102'
                    : 'bg-slate-900 text-slate-300 hover:bg-slate-800 hover:text-white border border-slate-800'
                }`}
              >
                <BookOpen className={`w-4 h-4 ${isActive ? 'text-slate-950' : 'text-amber-400'}`} />
                <span>{item.title}</span>
              </button>
            );
          })}
        </div>

        {/* Active Curriculum Detailed Card */}
        <div className="bg-slate-900 border border-slate-800 rounded-2xl p-6 sm:p-8 shadow-xl">
          <div className="flex flex-col md:flex-row md:items-center justify-between gap-4 pb-6 border-b border-slate-800">
            <div>
              <div className="flex items-center gap-3">
                <h3 className="text-xl sm:text-2xl font-bold text-white">{currentCurriculum.title}</h3>
                <span className="bg-amber-400/10 border border-amber-400/30 text-amber-300 text-xs font-bold px-2.5 py-0.5 rounded-full">
                  {currentCurriculum.badge}
                </span>
              </div>
              <p className="text-slate-400 text-sm mt-1">{currentCurriculum.subtitle}</p>
            </div>

            <button
              onClick={() => {
                setBoardType(currentCurriculum.title.includes('CBSE') ? 'CBSE' : currentCurriculum.title.includes('State') ? 'State Board' : 'Intermediate');
                setShowBookingModal(true);
              }}
              className="px-4 py-2.5 rounded-xl bg-amber-400 hover:bg-amber-300 text-slate-950 font-bold text-sm flex items-center justify-center gap-2 transition self-start md:self-auto shrink-0"
            >
              <Calendar className="w-4 h-4" />
              <span>Enroll in {currentCurriculum.title}</span>
            </button>
          </div>

          <div className="grid grid-cols-1 md:grid-cols-2 gap-8 pt-6">
            {/* Subjects Covered */}
            <div className="space-y-4">
              <h4 className="text-sm font-bold uppercase tracking-wider text-amber-400 flex items-center gap-2">
                <GraduationCap className="w-4 h-4" />
                <span>Subjects Covered</span>
              </h4>
              <div className="grid grid-cols-1 sm:grid-cols-2 gap-2.5">
                {currentCurriculum.subjects.map((sub, idx) => (
                  <div key={idx} className="bg-slate-800/70 border border-slate-700/60 rounded-lg p-3 text-sm font-medium text-slate-200 flex items-center gap-2">
                    <CheckCircle2 className="w-4 h-4 text-emerald-400 shrink-0" />
                    <span>{sub}</span>
                  </div>
                ))}
              </div>
            </div>

            {/* Highlights & Features */}
            <div className="space-y-4">
              <h4 className="text-sm font-bold uppercase tracking-wider text-amber-400 flex items-center gap-2">
                <Star className="w-4 h-4" />
                <span>Program Highlights</span>
              </h4>
              <ul className="space-y-2.5">
                {currentCurriculum.highlights.map((point, idx) => (
                  <li key={idx} className="flex items-start gap-2.5 text-sm text-slate-300">
                    <Check className="w-4 h-4 text-amber-400 shrink-0 mt-0.5" />
                    <span>{point}</span>
                  </li>
                ))}
              </ul>
            </div>
          </div>
        </div>
      </section>

      {/* Why Choose Lucky Tuitions Section */}
      <section id="why-us-section" className="py-12 bg-slate-900/50 border-y border-slate-800/80">
        <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
          <div className="text-center max-w-2xl mx-auto mb-10">
            <h2 className="text-2xl sm:text-3xl font-extrabold text-white">
              Why Parents Choose Lucky Tuitions
            </h2>
            <p className="text-slate-400 text-sm mt-1">
              Delivering disciplined mentorship, continuous feedback, and tangible academic breakthroughs.
            </p>
          </div>

          <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-6">
            {WHY_CHOOSE_US.map((item, idx) => {
              const Icon = item.icon;
              return (
                <div
                  key={idx}
                  className="bg-slate-900 border border-slate-800 rounded-2xl p-5 hover:border-amber-400/40 transition group hover:-translate-y-1 shadow-md"
                >
                  <div className="w-12 h-12 rounded-xl bg-amber-400/10 border border-amber-400/20 flex items-center justify-center mb-4 text-amber-400 group-hover:bg-amber-400 group-hover:text-slate-950 transition">
                    <Icon className="w-6 h-6" />
                  </div>
                  <h3 className="font-bold text-white text-base mb-2">{item.title}</h3>
                  <p className="text-slate-400 text-xs sm:text-sm leading-relaxed">{item.desc}</p>
                </div>
              );
            })}
          </div>
        </div>
      </section>

      {/* Bottom Consultation & Quick Contact Bar */}
      <footer id="contact-footer" className="mt-auto bg-slate-950 border-t border-slate-800 py-10 px-4 sm:px-6 lg:px-8">
        <div className="max-w-7xl mx-auto flex flex-col md:flex-row items-center justify-between gap-6">
          <div className="text-center md:text-left">
            <div className="flex items-center justify-center md:justify-start gap-2">
              <span className="font-black text-xl text-amber-400">LUCKY TUITIONS</span>
              <span className="text-xs text-slate-500">•</span>
              <span className="text-xs text-slate-400 font-medium">Personal Coaching Academy</span>
            </div>
            <p className="text-xs text-slate-400 mt-1 max-w-md">
              Doorstep home tutoring services for CBSE, State Syllabus, and Intermediate students across all city zones.
            </p>
          </div>

          {/* Direct CTA Buttons */}
          <div className="flex flex-wrap items-center justify-center gap-3">
            <a
              id="footer-call"
              href="tel:8520990880"
              className="flex items-center gap-2 px-4 py-2.5 rounded-xl bg-emerald-600 hover:bg-emerald-500 text-white font-bold text-sm shadow-md transition"
            >
              <Phone className="w-4 h-4" />
              <span>Call: 8520990880</span>
            </a>

            <a
              id="footer-whatsapp"
              href="https://wa.me/918520990880?text=Hello%20Lucky%20Tuitions,%20I%20am%20looking%20for%20a%20home%20tutor"
              target="_blank"
              rel="noopener noreferrer"
              className="flex items-center gap-2 px-4 py-2.5 rounded-xl bg-emerald-700/80 hover:bg-emerald-600 text-white font-bold text-sm border border-emerald-500/40 transition"
            >
              <MessageCircle className="w-4 h-4" />
              <span>WhatsApp Chat</span>
            </a>

            <button
              id="footer-demo"
              onClick={() => setShowBookingModal(true)}
              className="flex items-center gap-2 px-4 py-2.5 rounded-xl bg-amber-400 hover:bg-amber-300 text-slate-950 font-bold text-sm shadow-md transition"
            >
              <Calendar className="w-4 h-4" />
              <span>Book Demo</span>
            </button>
          </div>
        </div>

        <div className="max-w-7xl mx-auto mt-8 pt-6 border-t border-slate-900 text-center text-xs text-slate-500">
          © {new Date().getFullYear()} Lucky Tuitions. All rights reserved. Direct Helpline: +91 8520990880.
        </div>
      </footer>

      {/* Free Demo Booking Modal */}
      {showBookingModal && (
        <div className="fixed inset-0 z-50 flex items-center justify-center p-4 bg-black/75 backdrop-blur-sm animate-in fade-in">
          <div className="bg-slate-900 border border-slate-800 rounded-2xl max-w-lg w-full p-6 relative shadow-2xl">
            <button
              onClick={() => setShowBookingModal(false)}
              className="absolute top-4 right-4 text-slate-400 hover:text-white p-1 rounded-lg hover:bg-slate-800 transition"
            >
              <X className="w-5 h-5" />
            </button>

            {bookingSuccess ? (
              <div className="text-center py-8 space-y-4">
                <div className="w-14 h-14 bg-emerald-500/20 border border-emerald-500/30 rounded-full flex items-center justify-center mx-auto text-emerald-400">
                  <CheckCircle2 className="w-8 h-8" />
                </div>
                <h3 className="text-2xl font-bold text-white">Demo Request Received!</h3>
                <p className="text-slate-300 text-sm max-w-sm mx-auto">
                  Our academic coordinator will contact you at <strong className="text-amber-400">{parentPhone}</strong> within 2 hours to confirm your tutor assignment.
                </p>
              </div>
            ) : (
              <form onSubmit={handleBookingSubmit} className="space-y-4">
                <div>
                  <h3 className="text-xl font-bold text-white flex items-center gap-2">
                    <Calendar className="w-5 h-5 text-amber-400" />
                    <span>Book a Free Home Demo Class</span>
                  </h3>
                  <p className="text-xs text-slate-400 mt-1">
                    Experience our 1-on-1 coaching style at no cost before making a decision.
                  </p>
                </div>

                <div className="space-y-3">
                  <div>
                    <label className="block text-xs font-semibold text-slate-300 mb-1">Student's Full Name</label>
                    <div className="relative">
                      <User className="w-4 h-4 text-slate-500 absolute left-3 top-3" />
                      <input
                        type="text"
                        required
                        value={studentName}
                        onChange={(e) => setStudentName(e.target.value)}
                        placeholder="e.g. Rahul Sharma"
                        className="w-full pl-9 pr-3 py-2 bg-slate-800 border border-slate-700 rounded-lg text-white text-sm focus:border-amber-400 focus:outline-none"
                      />
                    </div>
                  </div>

                  <div>
                    <label className="block text-xs font-semibold text-slate-300 mb-1">Parent's Contact Phone</label>
                    <div className="relative">
                      <Phone className="w-4 h-4 text-slate-500 absolute left-3 top-3" />
                      <input
                        type="tel"
                        required
                        value={parentPhone}
                        onChange={(e) => setParentPhone(e.target.value)}
                        placeholder="e.g. 9876543210"
                        className="w-full pl-9 pr-3 py-2 bg-slate-800 border border-slate-700 rounded-lg text-white text-sm focus:border-amber-400 focus:outline-none"
                      />
                    </div>
                  </div>

                  <div className="grid grid-cols-2 gap-3">
                    <div>
                      <label className="block text-xs font-semibold text-slate-300 mb-1">Class / Grade</label>
                      <select
                        value={studentGrade}
                        onChange={(e) => setStudentGrade(e.target.value)}
                        className="w-full px-3 py-2 bg-slate-800 border border-slate-700 rounded-lg text-white text-sm focus:border-amber-400 focus:outline-none"
                      >
                        <option>Class 1st - 5th</option>
                        <option>Class 6th - 8th</option>
                        <option>Class 9th</option>
                        <option>Class 10th</option>
                        <option>Intermediate 1st Yr (+1)</option>
                        <option>Intermediate 2nd Yr (+2)</option>
                      </select>
                    </div>

                    <div>
                      <label className="block text-xs font-semibold text-slate-300 mb-1">Board / Syllabus</label>
                      <select
                        value={boardType}
                        onChange={(e) => setBoardType(e.target.value)}
                        className="w-full px-3 py-2 bg-slate-800 border border-slate-700 rounded-lg text-white text-sm focus:border-amber-400 focus:outline-none"
                      >
                        <option>CBSE</option>
                        <option>State Board</option>
                        <option>ICSE</option>
                        <option>Intermediate (BIE)</option>
                      </select>
                    </div>
                  </div>

                  <div>
                    <label className="block text-xs font-semibold text-slate-300 mb-1">Your Locality / Area</label>
                    <div className="relative">
                      <MapPin className="w-4 h-4 text-slate-500 absolute left-3 top-3" />
                      <input
                        type="text"
                        value={locality}
                        onChange={(e) => setLocality(e.target.value)}
                        placeholder="e.g. Madhapur, Kukatpally, Ameerpet"
                        className="w-full pl-9 pr-3 py-2 bg-slate-800 border border-slate-700 rounded-lg text-white text-sm focus:border-amber-400 focus:outline-none"
                      />
                    </div>
                  </div>

                  <div>
                    <label className="block text-xs font-semibold text-slate-300 mb-1">Preferred Time Slot</label>
                    <div className="relative">
                      <Clock className="w-4 h-4 text-slate-500 absolute left-3 top-3" />
                      <select
                        value={timing}
                        onChange={(e) => setTiming(e.target.value)}
                        className="w-full pl-9 pr-3 py-2 bg-slate-800 border border-slate-700 rounded-lg text-white text-sm focus:border-amber-400 focus:outline-none"
                      >
                        <option>Morning (6:30 AM - 8:30 AM)</option>
                        <option>Evening (4:30 PM - 6:30 PM)</option>
                        <option>Evening (6:30 PM - 8:30 PM)</option>
                        <option>Weekend Intensive</option>
                      </select>
                    </div>
                  </div>
                </div>

                <button
                  type="submit"
                  className="w-full py-3 rounded-xl bg-gradient-to-r from-amber-400 to-amber-500 hover:from-amber-300 hover:to-amber-400 text-slate-950 font-extrabold text-sm shadow-md transition mt-2 flex items-center justify-center gap-2"
                >
                  <Send className="w-4 h-4" />
                  <span>Confirm Free Demo Request</span>
                </button>
              </form>
            )}
          </div>
        </div>
      )}

      {/* Tuition Fee Estimator Modal */}
      {showFeeCalculator && (
        <div className="fixed inset-0 z-50 flex items-center justify-center p-4 bg-black/75 backdrop-blur-sm animate-in fade-in">
          <div className="bg-slate-900 border border-slate-800 rounded-2xl max-w-lg w-full p-6 relative shadow-2xl">
            <button
              onClick={() => setShowFeeCalculator(false)}
              className="absolute top-4 right-4 text-slate-400 hover:text-white p-1 rounded-lg hover:bg-slate-800 transition"
            >
              <X className="w-5 h-5" />
            </button>

            <div className="space-y-4">
              <div>
                <h3 className="text-xl font-bold text-white flex items-center gap-2">
                  <Calculator className="w-5 h-5 text-amber-400" />
                  <span>Tuition Fee Estimator</span>
                </h3>
                <p className="text-xs text-slate-400 mt-1">
                  Transparent monthly fee calculator based on grade and schedule intensity.
                </p>
              </div>

              <div className="space-y-4 pt-2">
                {/* Grade selector */}
                <div>
                  <label className="block text-xs font-semibold text-slate-300 mb-1.5">Grade Level</label>
                  <div className="grid grid-cols-4 gap-2">
                    {[
                      { id: 'primary', label: '1st - 5th' },
                      { id: 'middle', label: '6th - 8th' },
                      { id: 'high', label: '9th - 10th' },
                      { id: 'inter', label: '+1 & +2' }
                    ].map((g) => (
                      <button
                        key={g.id}
                        type="button"
                        onClick={() => setCalcGrade(g.id as any)}
                        className={`py-2 px-1 text-xs rounded-lg font-bold border transition ${
                          calcGrade === g.id
                            ? 'bg-amber-400 text-slate-950 border-amber-400'
                            : 'bg-slate-800 text-slate-300 border-slate-700 hover:bg-slate-700'
                        }`}
                      >
                        {g.label}
                      </button>
                    ))}
                  </div>
                </div>

                {/* Days per week */}
                <div>
                  <label className="block text-xs font-semibold text-slate-300 mb-1.5">Days Per Week</label>
                  <div className="grid grid-cols-3 gap-2">
                    {[
                      { days: 3, label: '3 Days / Wk' },
                      { days: 5, label: '5 Days / Wk' },
                      { days: 6, label: '6 Days / Wk' }
                    ].map((d) => (
                      <button
                        key={d.days}
                        type="button"
                        onClick={() => setCalcDays(d.days)}
                        className={`py-2 text-xs rounded-lg font-bold border transition ${
                          calcDays === d.days
                            ? 'bg-amber-400 text-slate-950 border-amber-400'
                            : 'bg-slate-800 text-slate-300 border-slate-700 hover:bg-slate-700'
                        }`}
                      >
                        {d.label}
                      </button>
                    ))}
                  </div>
                </div>

                {/* Number of Subjects */}
                <div>
                  <label className="block text-xs font-semibold text-slate-300 mb-1.5">
                    Number of Subjects: <span className="text-amber-400 font-bold">{calcSubjects}</span>
                  </label>
                  <input
                    type="range"
                    min="1"
                    max="4"
                    value={calcSubjects}
                    onChange={(e) => setCalcSubjects(parseInt(e.target.value))}
                    className="w-full accent-amber-400 cursor-pointer"
                  />
                  <div className="flex justify-between text-[11px] text-slate-500 px-1 mt-1">
                    <span>1 Subject</span>
                    <span>2 Subjects</span>
                    <span>3 Subjects</span>
                    <span>All Core (4+)</span>
                  </div>
                </div>

                {/* Estimate Result Box */}
                <div className="bg-slate-800/80 border border-amber-500/30 rounded-xl p-4 text-center space-y-1">
                  <span className="text-xs text-slate-400 uppercase tracking-wider font-semibold">
                    Estimated Monthly Investment
                  </span>
                  <div className="text-3xl font-black text-transparent bg-clip-text bg-gradient-to-r from-amber-300 to-yellow-400">
                    ₹{calculateEstimatedFee().toLocaleString('en-IN')} <span className="text-xs text-slate-400 font-medium">/ month</span>
                  </div>
                  <p className="text-[11px] text-slate-400">
                    Includes 1-on-1 home visits, weekly tests, formula worksheets, and parent review logs.
                  </p>
                </div>
              </div>

              <div className="flex gap-3 pt-2">
                <button
                  type="button"
                  onClick={() => {
                    setShowFeeCalculator(false);
                    setShowBookingModal(true);
                  }}
                  className="flex-1 py-2.5 rounded-xl bg-amber-400 hover:bg-amber-300 text-slate-950 font-bold text-sm transition"
                >
                  Book Demo at this Rate
                </button>
                <button
                  type="button"
                  onClick={() => setShowFeeCalculator(false)}
                  className="px-4 py-2.5 rounded-xl bg-slate-800 hover:bg-slate-700 text-slate-300 text-sm font-semibold transition"
                >
                  Close
                </button>
              </div>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}

package com.example.myapplication



object Constants {
    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_answer"
    const val CORRECT_QUESTIONS : String = "correct_answers"


    fun getQuestions() : ArrayList<Questions>
    {
        val questionsList = ArrayList<Questions>()
        val questionOne = Questions(1,"what country does this flag belong to?",R.drawable.ic_flag_of_argentina,"Argentina","Australia","USA","Austria",1)
        questionsList.add(questionOne)
        val questionTwo = Questions(2,"what country does this flag belong to?",R.drawable.ic_flag_of_australia,"Belgium","Brazil","Australia","Austria",3)
        questionsList.add(questionTwo)
        val questionThree = Questions(3,"what country does this flag belong to?",R.drawable.ic_flag_of_belgium,"Argentina","Australia","Armenia","Belgium",4)
        questionsList.add(questionThree)
        val questionFour = Questions(4,"what country does this flag belong to?",R.drawable.ic_flag_of_brazil,"Argentina","Australia","Brazil","Austria",3)
        questionsList.add(questionFour)
        val questionFive = Questions(5,"what country does this flag belong to?",R.drawable.ic_flag_of_denmark,"Denmark","Fiji","Jordan","Austria",1)
        questionsList.add(questionFive)
        val questionSix = Questions(6,"what country does this flag belong to?",R.drawable.ic_flag_of_fiji,"Argentina","Iraq","Armenia","Fiji",4)
        questionsList.add(questionSix)
        val questionSeven = Questions(7,"what country does this flag belong to?",R.drawable.ic_flag_of_germany,"Palestine","Germany","Armenia","Austria",2)
        questionsList.add(questionSeven)
        val questionEight = Questions(8,"what country does this flag belong to?",R.drawable.ic_flag_of_india,"India","China","Curia","Pakistan",1)
        questionsList.add(questionEight)
        val questionNine = Questions(9,"what country does this flag belong to?",R.drawable.ic_flag_of_kuwait,"Canada","Kuwait","Egypt","Austria",2)
        questionsList.add(questionNine)
        val questionTen = Questions(10,"what country does this flag belong to?",R.drawable.ic_flag_of_new_zealand,"Argentina","Australia","newZealand","UAE",3)
        questionsList.add(questionTen)
        return questionsList

    }


}
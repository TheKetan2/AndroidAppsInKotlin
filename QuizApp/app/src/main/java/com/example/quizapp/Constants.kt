package com.example.quizapp

object Constants{
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestion():ArrayList<Question>{
        val questionsList = ArrayList<Question>()


        val que1 = Question(
            1,"What is the name of this animal?",
            R.drawable.beaver,
             "Beaver", "Cat",
            "Tiger", "Cow",  1
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
            2, "What is the name of this animal?",
            R.drawable.bison,
            "Pig", "Beaver",
            "Bison", "Bear", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "What is the name of this animal?",
            R.drawable.boar,
            "Bull", "Monkey",
            "Goat", "Boar", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "What is the name of this animal?",
            R.drawable.camel,
            "Ant", "Camel",
            "Squirrel", "Sheep", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "What is the name of this animal?",
            R.drawable.cat,
            "Baboon", "Lion",
            "Cat", "Mongoose", 3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.deer,
            "Deer", "Goat",
            "Elephant", "Giraffe", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, "What is the name of this animal?",
            R.drawable.dog,
            "Cat", "Tiger",
            "Dog", "Panda", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, "What is the name of this mammal?",
            R.drawable.dolphin,
            "Man", "Aquaman",
            "Whale", "Dolphin", 4
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "What is the name of this animal?",
            R.drawable.donkey,
            "Camel", "Donkey",
            "Lama", "Horse", 2
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, "What is the name of this bird?",
            R.drawable.duck,
            "Duck", "Peacock",
            "Crow", "Eagle", 1
        )

        questionsList.add(que10)


        return questionsList
    }

}
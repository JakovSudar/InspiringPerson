package com.example.inspiringperson

object InspiringPersonRepository {
    val persons : MutableList<Person>

    init {
        persons = retrievePersons()
    }
    private fun retrievePersons(): MutableList<Person> {
        val teslaQuotes = listOf<String>(
            "I don’t care that they stole my idea …  I care that they don’t have any of their own.",
            "The scientists of today think deeply instead of clearly. One must be sane to think clearly, but one can think deeply and be quite insane.",
            "Of all things, I liked books best.",
            "I do not think you can name many great inventions that have been made by married men."
        )

        val ritchieQuotes = listOf<String>(
            "UNIX is basically a simple operating system, but you have to be a genius to understand the simplicity.",
            "C++ and Java, say, are presumably growing faster than plain C, but I bet C will still be around.",
            "The only way to learn a new programming language is by writing programs in it."
        )

        val jobsQuotes = listOf<String>(
            "Don’t let the noise of others’ opinions drown out your own inner voice.",
            "Creativity is just connecting things.",
            "Sometimes when you innovate, you make mistakes. It is best to admit them quickly, and get on with improving your other innovations."
        )

        return mutableListOf(
            Person(1, "Nikola Tesla","10.7.1943.","Born and raised in the Austrian Empire, Tesla studied engineering and physics in the 1870s without receiving a degree, and gained practical experience in the early 1880s working in telephony and at Continental Edison in the new electric power industry. ",
                "https://www.biography.com/.image/t_share/MTY2Njc5MTIyNzY2OTk2NTM1/nikola_tesla_napoleon-sarony-public-domain-via-wikimedia-commons.jpg",teslaQuotes),
            Person(2, "Dennis Ritchie","9.9.1941.","Ritchie is best known as the creator of the C programming language, a key developer of the Unix operating system, and co-author of the book The C Programming Language; he was the 'R' in K&R (a common reference to the book's authors Kernighan and Ritchie). Ritchie worked together with Ken Thompson, who is credited with writing the original version of Unix. ",
                "https://www.invent.org/sites/default/files/styles/inductee_detail_media/public/inductees/2019-02/Ritchie%2C-Dennis_b%26w.jpg?h=157d851b&itok=HAZRfT8c",ritchieQuotes),
            Person(3, "Steve Jobs","24.2.1955.","Jobs was born in San Francisco, California, and put up for adoption. He was raised in the San Francisco Bay Area. He attended Reed College in 1972 before dropping out that same year, and traveled through India in 1974 seeking enlightenment and studying Zen Buddhism.",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dc/Steve_Jobs_Headshot_2010-CROP_%28cropped_2%29.jpg/220px-Steve_Jobs_Headshot_2010-CROP_%28cropped_2%29.jpg",jobsQuotes)
        )
    }


    fun remove(id:Int) = persons.removeAll{person -> person.id == id}
    fun get(id: Int) : Person? = persons.find { person -> person.id == id }
    fun add (person: Person) = persons.add(person)

}
package com.sample.movieadvisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findGames = findViewById<Button>(R.id.find_genres)

        findGames.setOnClickListener {
            val movieGenres = findViewById<Spinner>(R.id.movieGenres)
            val genre = movieGenres.selectedItem
            val movieList = getMovies(genre.toString())
            val reducedMovieList = movieList.reduce {str, item -> str + '\n' + item}
            val movie = findViewById<TextView>(R.id.movie)
            movie.text = reducedMovieList
            val moviegenre = findViewById<TextView>(R.id.genreExplain)
            moviegenre.text = getGenreExplanation(genre.toString())
        }
    }

    private fun getMovies(genre: String) : List<String> {
        return when (genre) {
            "Action" -> listOf("Top Gun", "Top Gun Maverick")
            "Adventure" -> listOf("Jumanji", "The Lord Of Rings")
            "Comedy" -> listOf("13 becomes 30", "No Strings Attached")
            "Sports" -> listOf("Jerry Maguire", "Rush")
            "Romantic" -> listOf("500 Days of Summer", "There is something about Mary")
            else -> listOf("Conjuring", "Anabelle")
        }
    }

   private fun getGenreExplanation(genre:String) : String {
        return when (genre) {
            "Action" -> "Full Fledged intense Action Scenes"
            "Adventure" -> "Hero Goes on an adventure to a new place"
            "Comedy" -> "Heartfelt comedies making people laugh"
            "Sports" -> "Sport based films"
            "Romantic" -> "Love and love only"
            else -> "Horror Movies"
        }
    }
}
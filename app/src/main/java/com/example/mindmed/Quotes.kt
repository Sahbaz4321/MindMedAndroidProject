//import android.annotation.SuppressLint
//import android.os.Bundle
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import com.example.mindmed.R
//
//class Quotes : AppCompatActivity() {
//
//    private val images = listOf(
//        R.drawable.motivation1,
//        R.drawable.motivation2,
//        R.drawable.motivation3
//    )
//
//    private val quotes = listOf(
//        "Believe in yourself and all that you are.",
//        "Push yourself, because no one else is going to do it for you.",
//        "Your limitation—it’s only your imagination.",
//        "Success doesn’t just find you. You have to go out and get it."
//    )
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_quotes)
//
//        val backgroundImage: ImageView = findViewById(R.id.backgroundImage)
//        val quoteText: TextView = findViewById(R.id.quoteText)
//
//        // Pick a random image and quote
//        val randomImage = images[Random.nextInt(images.size)]
//        val randomQuote = quotes[Random.nextInt(quotes.size)]
//
//        backgroundImage.setImageResource(randomImage)
//        quoteText.text = randomQuote
//    }
//}

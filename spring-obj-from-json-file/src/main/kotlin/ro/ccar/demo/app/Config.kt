package ro.ccar.demo.app

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import com.google.gson.Gson
import com.google.common.io.Resources
import java.nio.charset.StandardCharsets

@Configuration
class Config {

    @Bean
    fun getBranches(): Branches {
        return Branches(
            Gson().fromJson(
                getFileAsString("data/branches.json"),
                Branches::class.java).branches.sortedWith(compareBy { it.name }))
    }

    private fun getFileAsString(filePath: String) =
        Resources.toString(Resources.getResource(filePath), StandardCharsets.UTF_8)
}
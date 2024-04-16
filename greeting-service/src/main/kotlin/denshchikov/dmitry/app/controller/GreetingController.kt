package denshchikov.dmitry.app.controller

import denshchikov.dmitry.model.request.UserDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/greetings")
class GreetingController {

    val userStorage = HashMap<UUID, String>()

    @PostMapping
    fun createGreeting(@RequestBody req: UserDto): UUID {
        val userId = UUID.randomUUID()
        userStorage[userId] = "Hello, ${req.name} ${req.lastName}!"
        return userId
    }

    @GetMapping("/{id}")
    fun getGreeting(@RequestParam id: UUID) = userStorage[id] ?: "No greeting was found"

}
package denshchikov.dmitry.app.controller

import denshchikov.dmitry.app.model.CreateUserRequest
import denshchikov.dmitry.client.GreetingClient
import denshchikov.dmitry.model.request.UserDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(val greetingClient: GreetingClient) {

    @PostMapping
    fun createUser(@RequestBody req: CreateUserRequest): String {
        val userDto = UserDto(req.name, req.lastName)
        val greetingId = greetingClient.createGreeting(userDto)
        return greetingClient.getGreeting(greetingId)
    }

}
package denshchikov.dmitry.client

import denshchikov.dmitry.model.request.UserDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import java.util.UUID

@FeignClient(name = "greetingClient", url = "\${app.feign.client}")
interface GreetingClient {

    @PostMapping("/greetings")
    fun createGreeting(@RequestBody req: UserDto): UUID

    @GetMapping("/greetings/{id}")
    fun getGreeting(@RequestParam id: UUID): String

}
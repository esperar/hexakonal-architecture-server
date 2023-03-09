package esperer.hexakonal.global.filter

import esperer.hexakonal.domain.user.application.JwtParserPort
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import java.security.Security
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtRequestFilter(
    private val jwtParserPort: JwtParserPort
): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        val accessToken = jwtParserPort.parseAccessToken(request)
        if(!accessToken.isNullOrBlank()){
            val authentication = jwtParserPort.authentication(accessToken)
            SecurityContextHolder.clearContext()
            val securityContext = SecurityContextHolder.getContext()
            securityContext.authentication = authentication
        }
        filterChain.doFilter(request, response)
    }
}
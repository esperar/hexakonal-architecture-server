package esperer.hexakonal.global.security.jwt.auth

import esperer.hexakonal.domain.user.adapter.persistence.entity.UserEntity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthDetails(
    private val user: UserEntity
): UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> =
        user.authority

    override fun getPassword(): String? = null

    override fun getUsername(): String = user.id.toString()

    override fun isAccountNonExpired(): Boolean = false

    override fun isAccountNonLocked(): Boolean = false

    override fun isCredentialsNonExpired(): Boolean = false

    override fun isEnabled(): Boolean = false
}
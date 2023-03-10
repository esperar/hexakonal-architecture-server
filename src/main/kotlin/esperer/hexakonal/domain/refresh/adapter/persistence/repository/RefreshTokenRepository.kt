package esperer.hexakonal.domain.refresh.adapter.persistence.repository

import esperer.hexakonal.domain.refresh.adapter.persistence.entity.RefreshTokenEntity
import org.springframework.data.repository.CrudRepository


interface RefreshTokenRepository: CrudRepository<RefreshTokenEntity, String> {
}
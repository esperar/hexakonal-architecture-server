package esperer.hexakonal.domain.user.adapter.persistence.entity

import esperer.hexakonal.domain.user.adapter.presentation.data.enums.Authority
import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "user")
class UserEntity(
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", nullable = false, name = "user_id")
    val id: UUID,
    val email: String,
    val password: String,
    val name: String,

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_authority", joinColumns = [JoinColumn(name = "user_id")])
    val authority: MutableList<Authority>
) {

}
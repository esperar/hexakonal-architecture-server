package esperer.hexakonal.global.annotation.adapter

import org.springframework.stereotype.Component

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Component
annotation class ReadOnlyAdapter()

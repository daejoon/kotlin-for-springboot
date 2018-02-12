package d2

import javax.persistence.*

/**
 * @Author kdj
 * @Date 2018. 2. 12.
 */
@Entity
@Table(name = "HELLO")
data class User(@Id
            @GeneratedValue(strategy = GenerationType.AUTO)
            var id: Long? = null,
            var name: String)
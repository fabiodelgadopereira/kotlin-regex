package com.example.demo.service

import org.springframework.stereotype.Service

@Service
public  class PasswordService {

    fun regexPasswordValidation(value : String): Boolean{
        try {

             return  """^(?!([A-Za-z])(.*\1))(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@${'$'}!%*?&])[A-Za-z\d@${'$'}!%*?&]{9,}${'$'}""".toRegex().containsMatchIn(value)
            //  return  """^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{9,}$""".toRegex().containsMatchIn(value)
            // return  """^(?!([A-Za-z])(.*\1)).*${'$'}""".toRegex().containsMatchIn(value)
        } catch (e: Exception) {
            return false
        }
    }
}
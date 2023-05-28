package com.m6z1.test_0525

// 직렬화
data class Selected(
    val selectedPeople: String,
    val selectedBusId: String,
    val msg: String
) : java.io.Serializable {
    companion object {
        val empty = Selected("", "", "")
    }
}

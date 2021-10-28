package com.example.myapplication.data

import com.google.firebase.database.Exclude

class Contact(
    @get: Exclude
    var id: String? = null,
    var FullName: String? = null,
    var contactNumber: String? = null,
    @get: Exclude
    var isDeleted: Boolean =false
) {
    override fun equals(other: Any?): Boolean {
        return if(other is Contact){
            other.id ==id
        }else false
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + isDeleted.hashCode()
        result = 31 * result + (FullName?.hashCode() ?: 0)
        result = 31 * result + (contactNumber?.hashCode() ?: 0)
        return result
    }
}
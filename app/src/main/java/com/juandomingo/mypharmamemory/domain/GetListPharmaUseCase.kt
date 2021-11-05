package com.juandomingo.mypharmamemory.domain

import com.juandomingo.mypharmamemory.data.PharmaRepository
import com.juandomingo.mypharmamemory.data.model.PharmacoModel

class GetListPharmaUseCase {
    /*  Los datos del repo externo se acabarán inyectando. De momento, guardamos
    *   en Provider los datos.  */
    private val repository = PharmaRepository()
    /*  La palabra reservada 'invoke', sirve para que al llamar
    *   a this.class, automáticamente se ejecute esta función.  */
    suspend operator fun invoke(): List<PharmacoModel>? = repository.getAllPharma()
}
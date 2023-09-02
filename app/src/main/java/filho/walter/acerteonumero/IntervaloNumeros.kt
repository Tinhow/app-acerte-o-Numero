package filho.walter.acerteonumero

class IntervaloNumeros(private var min: Int, private var max: Int){

    private val numeroSorteado = (min+1 until max).random()
    private var status = JogoStatus.EXECUTANDO
    private lateinit var numeroStatus: NumeroStatus

    fun getMin(): Int {
        return this.min
    }

    fun getMax(): Int {
        return this.max
    }

    fun getStatus(): JogoStatus {
        return this.status
    }

    fun getNumeroStatus(): NumeroStatus {
        return this.numeroStatus
    }

    private fun isInvalid(numero: Int) : Boolean {
        return numero <= this.min || numero >= this.max
    }

    private fun mudarLimites(numero: Int) {
        if(numero < this.numeroSorteado) {
            this.min = numero
            this.numeroStatus = NumeroStatus.MENOR_QUE_O_SORTEADO
        } else if(numero > this.numeroSorteado) {
            this.max = numero
            this.numeroStatus = NumeroStatus.MAIOR_QUE_O_SORTEADO
        }
    }

    private fun fimIntervalo(): Boolean {
        return this.min+1 == this.max-1
    }

    public fun chute(numero: Int){
        if(isInvalid(numero)) {
            this.status = JogoStatus.PERDEU
        } else if(numero == this.numeroSorteado) {
            this.status = JogoStatus.GANHOU
            this.numeroStatus = NumeroStatus.ACERTOU
        } else {
            mudarLimites(numero)
            if(fimIntervalo()) {
                this.status = JogoStatus.PERDEU
                this.numeroStatus = NumeroStatus.PERDEU
            }
        }

    }

}

enum class JogoStatus {
    GANHOU, PERDEU, EXECUTANDO
}

enum class NumeroStatus {
    MAIOR_QUE_O_SORTEADO, MENOR_QUE_O_SORTEADO, ACERTOU, PERDEU
}
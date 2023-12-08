# desafio-parcelas

Modificações
https://github.com/luismendes070/desafio-parcelas/blob/main/credit-application-system/src/test/kotlin/me/dio/credit/application/system/service/CustomerServiceTest.kt
<code>

@Test
fun `should the date of the first installment must be a maximum of 3 months after the current day`() {
//given
val fakeCustomer: Customer = buildCustomer()
every { customerRepository.save(any()) } returns fakeCustomer
//when
val actual: Customer = customerService.save(fakeCustomer)
//then ChatGPT

        // Get the current date and time
        val currentDate = LocalDateTime.now()

        // Calculate the date for the first installment (maximum 3 months from now)
        val firstInstallmentDate = currentDate.plusMonths(3)

        // Print the result
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        println("Current Date and Time: ${currentDate.format(formatter)}")
        println("First Installment Date: ${firstInstallmentDate.format(formatter)}")

        // Use AssertJ to make assertions
        assertThat(firstInstallmentDate).isAfterOrEqualTo(currentDate)
                .isBeforeOrEqualTo(currentDate.plusMonths(3))

        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(fakeCustomer)
        verify(exactly = 1) { customerRepository.save(fakeCustomer) }
    }

    @Test
    fun `should the maximum installments allowed will be 48`() {
        //given
        val fakeCustomer: Customer = buildCustomer()
        every { customerRepository.save(any()) } returns fakeCustomer
        //when
        val actual: Customer = customerService.save(fakeCustomer)

        // actual.installments = 48

        //then
        Assertions.assertThat(actual.installments).isSameAs(fakeCustomer.installments)
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(fakeCustomer)
        verify(exactly = 1) { customerRepository.save(fakeCustomer) }
    }


https://github.com/luismendes070/desafio-parcelas/blob/main/credit-application-system/src/main/kotlin/me/dio/credit/application/system/entity/Customer.kt

        @Column(nullable = false) var currentDay: LocalDateTime = LocalDateTime.now(),
        @Column(nullable = false) var installments: Int = 0,

    private fun buildCustomer(
            currentDay: LocalDateTime = LocalDateTime.now(),
            installments: Int = 48,
            firstName: String = "Cami",
            lastName: String = "Cavalcante",
            cpf: String = "28475934625",
            email: String = "camila@gmail.com",
            password: String = "12345",
            zipCode: String = "12345",
            street: String = "Rua da Cami",
            income: BigDecimal = BigDecimal.valueOf(1000.0),
            id: Long = 1L
    ) = Customer(
            currentDay = currentDay,
            installments = installments,
            firstName = firstName,
            lastName = lastName,
            cpf = cpf,
            email = email,
            password = password,
            address = Address(
                    zipCode = zipCode,
                    street = street,
            ),
            income = income,
            id = id
    )

  </code>

IntelliJ plugins
Hiberbee
Rainbow brackets
Mario Progress Bar

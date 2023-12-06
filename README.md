# desafio-parcelas

Modificações
https://github.com/luismendes070/desafio-parcelas/blob/main/credit-application-system/src/test/kotlin/me/dio/credit/application/system/service/CustomerServiceTest.kt
<code>
@Test
  fun `should the date of the first installment must be a maximum of 3 months after the current day`(){
    //given
    val fakeCustomer: Customer = buildCustomer()
    every { customerRepository.save(any()) } returns fakeCustomer
    //when
    val actual: Customer = customerService.save(fakeCustomer)
    //then
    Assertions.assertThat(actual.currentDay,90)
    Assertions.assertThat(actual).isNotNull
    Assertions.assertThat(actual).isSameAs(fakeCustomer)
    verify(exactly = 1) { customerRepository.save(fakeCustomer) }
  }

  @Test
  fun `should the maximum installments allowed will be 48`(){
    //given
    val fakeCustomer: Customer = buildCustomer()
    every { customerRepository.save(any()) } returns fakeCustomer
    //when
    val actual: Customer = customerService.save(fakeCustomer)
    //then
    Assertions.assertThat(actual.installments,48)
    Assertions.assertThat(actual).isNotNull
    Assertions.assertThat(actual).isSameAs(fakeCustomer)
    verify(exactly = 1) { customerRepository.save(fakeCustomer) }
  }

https://github.com/luismendes070/desafio-parcelas/blob/main/credit-application-system/src/main/kotlin/me/dio/credit/application/system/entity/Customer.kt

          @Column(nullable = false) var currentDay: LocalDate = "2023-12-06",
        @Column(nullable = false) var installments: Int = 0,

  </code>

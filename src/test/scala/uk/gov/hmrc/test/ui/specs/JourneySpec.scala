/*
 * Copyright 2022 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.ui.specs

import uk.gov.hmrc.test.ui.pages._
import uk.gov.hmrc.test.ui.specs.tags.ZapTests

class JourneySpec extends BaseSpec {

  Feature("Journeys for completing the form") {

    Scenario("User living in the UK", ZapTests) {

      Given("I am on the start page")
      StartPage.loadPage()

      When("I complete the journey")
      StartPage.startNow()
      ApplicantNamePage.answer()
      ApplicantNinoPage.answer()
      ApplicantHasUtrPage.answerYes()
      ApplicantUtrPage.answer()

      PartnerNamePage.answer()
      PartnerNinoPage.answer()
      PartnerHasUtrPage.answerYes()
      PartnerUtrPage.answer()
      CurrentAddressInUkPage.answerYes()
      CurrentAddressUkPage.answer()

      PropertyAddressPage(1).answer()
      ShareOfPropertyPage(1).answer()
      CheckPropertyPage(1).continue()
      AddPropertyPage.answerYes()

      PropertyAddressPage(2).answer()
      ShareOfPropertyPage(2).answer()
      CheckPropertyPage(2).continue()
      AddPropertyPage.answerNo()

      CheckYourAnswersPage.onPage()

      Then("I must be able to download the PDF")
      // TODO
    }

    Scenario("User living outside the UK", ZapTests) {

      Given("I am on the start page")
      StartPage.loadPage()

      When("I complete the journey")
      StartPage.startNow()
      ApplicantNamePage.answer()
      ApplicantNinoPage.answer()
      ApplicantHasUtrPage.answerYes()
      ApplicantUtrPage.answer()

      PartnerNamePage.answer()
      PartnerNinoPage.answer()
      PartnerHasUtrPage.answerYes()
      PartnerUtrPage.answer()
      CurrentAddressInUkPage.answerNo()
      CurrentAddressInternationalPage.answer()

      PropertyAddressPage(1).answer()
      ShareOfPropertyPage(1).answer()
      CheckPropertyPage(1).continue()
      AddPropertyPage.answerYes()

      PropertyAddressPage(2).answer()
      ShareOfPropertyPage(2).answer()
      CheckPropertyPage(2).continue()
      AddPropertyPage.answerNo()

      CheckYourAnswersPage.onPage()

      Then("I must be able to download the PDF")
      // TODO
    }
  }
}

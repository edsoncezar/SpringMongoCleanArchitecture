import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder

class AddOrRemoveUsers extends Simulation {
          
  val userString = "{  \n" + 
          "   \"users\":[  \n" + 
          "      {  \n" + 
          "         \"user\":\"edson\",\n" + 
          "         \"password\":\"123test\"\n" + 
          "      }\n" + 
          "   ]\n" + 
          "}"

  val theHttpProtocolBuilder = http.baseUrl("http://localhost:8080/v1/users")

  val theScenarioBuilder = scenario("Scenario1")
    .exec(
      http("addOrRemoveUsers")
        .post("/")
        .body(StringBody(userString)).asJson
        .check(status is 202))

  setUp(
    theScenarioBuilder.inject(atOnceUsers(1000))).protocols(theHttpProtocolBuilder)
}
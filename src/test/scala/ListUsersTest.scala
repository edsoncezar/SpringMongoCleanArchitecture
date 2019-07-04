import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder

class ListUsersTest extends Simulation {

  val theHttpProtocolBuilder = http
    .baseUrl("http://localhost:8080/v1/users")

  val theScenarioBuilder = scenario("Scenario3")
    .exec(
      http("listUsersByUser")
        .get("?user=1"))

  setUp(
    theScenarioBuilder.inject(atOnceUsers(1000))).protocols(theHttpProtocolBuilder)
}
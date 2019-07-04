import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder

class ListAllUsersTest extends Simulation {

  val theHttpProtocolBuilder = http
    .baseUrl("http://localhost:8080/v1/users")

  val theScenarioBuilder = scenario("Scenario2")
    .exec(
      http("listAllUsers")
        .get("/listAll"))

  setUp(
    theScenarioBuilder.inject(atOnceUsers(1000))).protocols(theHttpProtocolBuilder)
}

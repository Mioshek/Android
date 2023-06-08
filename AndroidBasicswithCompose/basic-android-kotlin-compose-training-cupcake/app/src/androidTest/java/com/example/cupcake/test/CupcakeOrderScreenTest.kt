import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.cupcake.ui.SelectOptionScreen
import com.example.cupcake.ui.theme.CupcakeTheme
import org.junit.Rule
import org.junit.Test
import com.example.cupcake.R
import com.example.cupcake.data.OrderUiState
import com.example.cupcake.test.onNodeWithStringId
import com.example.cupcake.ui.OrderSummaryScreen
import com.example.cupcake.ui.StartOrderScreen

class CupcakeOrderScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val fakeOrderUiState = OrderUiState(
        quantity = 8,
        flavor = "Mioshek",
        date = "someday",
        price = "$100",
        pickupOptions = listOf()
    )

    @Test
    fun selectOptionScreen_verifyContent(){
        val flavors = listOf("Vanilla", "Chocolate", "Hazelnut", "Cookie", "Mango")
        val subTotal = "$100"

        composeTestRule.setContent {
            CupcakeTheme {
                SelectOptionScreen(subtotal = subTotal, options = flavors)
            }
        }

        flavors.forEach{flavor ->
            composeTestRule.onNodeWithText(flavor).assertIsDisplayed()
        }

        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(
                R.string.subtotal_price,
                subTotal
            )
        ).assertIsDisplayed()

        composeTestRule.onNodeWithStringId(R.string.next).assertIsNotEnabled()

    }

    @Test
    fun selectOptionScreen_flavorSelected_verifyContent(){
        val flavors = listOf("Vanilla", "Chocolate", "Hazelnut", "Cookie", "Mango")
        val subTotal = "$100"

        composeTestRule.setContent {
            CupcakeTheme {
                SelectOptionScreen(subtotal = subTotal, options = flavors)
            }
        }

        composeTestRule.onNodeWithText("Chocolate").performClick()

        composeTestRule.onNodeWithStringId(R.string.next).assertIsEnabled()
    }

    @Test
    fun startScreen_verifyContent(){
        val numbers = listOf(Pair(R.string.one_cupcake,1), Pair(R.string.six_cupcakes,6), Pair(R.string.twelve_cupcakes,12))

        composeTestRule.setContent {
            CupcakeTheme {
                StartOrderScreen(quantityOptions = numbers, onNextButtonClicked = {})
            }
        }

        numbers.forEach { number ->
            composeTestRule.onNodeWithStringId(number.first).assertIsDisplayed()
        }

        composeTestRule.onNodeWithText("Order Cupcakes").assertIsDisplayed()
    }

    @Test
    fun summaryScreen_verifyContent(){

        composeTestRule.setContent {
            CupcakeTheme {
                OrderSummaryScreen(fakeOrderUiState, onCancelButtonClicked = {}, onSendButtonClicked = {_,_ ->})
            }
        }

        composeTestRule.onNodeWithText(fakeOrderUiState.flavor).assertIsDisplayed()
        composeTestRule.onNodeWithText(fakeOrderUiState.price).assertIsDisplayed()
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(
                R.string.subtotal_price,
                fakeOrderUiState.price
            )
        )
    }
}
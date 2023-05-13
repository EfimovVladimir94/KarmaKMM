package login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.azri.karma.android.core_compose.R
import login.models.LoginEvent
import login.models.LoginViewState
import theme.Theme

@Composable
fun LoginView(
    state: LoginViewState,
    eventHandler: (LoginEvent) -> Unit)
{
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
    ) {
        Column {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.authlogo),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(horizontal = 74.dp)
                        .padding(top = 68.dp)
                )
                OutlinedTextField(
                    value = state.email,
                    onValueChange = {eventHandler.invoke(LoginEvent.EmailChanged(it))},
                    placeholder = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Логин",
                                color = Theme.colors.highlightTextColor,
                                fontFamily = Theme.fonts.montserratFamily,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.login),
                            contentDescription = "Login",
                            tint = Theme.colors.primaryColor,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp)
                        .padding(top = 21.dp)
                        .border(
                            width = 1.dp,
                            shape = RoundedCornerShape(10.dp),
                            color = Color.LightGray
                        ),
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.Black,
                        focusedBorderColor = Color.Unspecified,
                        unfocusedBorderColor = Color.Unspecified
                    )
                )
                OutlinedTextField(
                    value = state.password,
                    onValueChange = {eventHandler.invoke(LoginEvent.PasswordChanged(it))},
                    placeholder = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Пароль",
                                color = Theme.colors.highlightTextColor,
                                fontFamily = Theme.fonts.montserratFamily,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.padlock),
                            contentDescription = "padlock",
                            tint = Theme.colors.primaryColor,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    trailingIcon = {
                        Icon(
                            modifier = Modifier
                                .size(27.dp)
                                .clickable {
                                    eventHandler.invoke(LoginEvent.PasswordShowClick)
                                },
                            painter = painterResource(id = if (state.isShowPassword)
                                R.drawable.eye_close
                            else
                                R.drawable.eye
                            ),
                            contentDescription = "Password hidden",
                            tint = Theme.colors.primaryColor
                        )
                    },
                    visualTransformation = if(state.isShowPassword) {
                        PasswordVisualTransformation()
                    } else {
                        VisualTransformation.None
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp)
                        .padding(top = 21.dp)
                        .border(
                            width = 1.dp,
                            shape = RoundedCornerShape(10.dp),
                            color = Color.LightGray
                        ),
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Theme.colors.primaryColor,
                        unfocusedBorderColor = Color.Unspecified,
                        focusedBorderColor = Color.Unspecified
                    )
                )
                HintFieldView(
                    modifier = Modifier.padding(top = 15.dp),
                    description = "Забыли пароль?",
                    title = "Нажмите сюда"
                ) {
                    eventHandler.invoke(LoginEvent.ForgotClick)
                }

                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 33.dp)
                    .padding(top = 24.dp)
                    .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Theme.colors.primaryColor
                    ),
                    shape = RoundedCornerShape(10.dp),
                    onClick = { eventHandler.invoke(LoginEvent.LoginClick) },
                    content = {
                        Text(
                            "Вход",
                            color = Color.White,
                            fontSize = 17.sp,
                            fontFamily = Theme.fonts.montserratFamily,
                            fontWeight = FontWeight.Bold
                        )
                    }
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 35.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Авторизация через соц. сети",
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontFamily = Theme.fonts.montserratFamily,
                    fontWeight = FontWeight.Medium
                )
                MessengersAuth(handler = {
                    //: TODO сделать авторизацию через соц сети
                })
                HintFieldView(
                    modifier = Modifier.padding(top = 24.dp),
                    description = "Нет аккаунта?",
                    title = "Зарегистрироваться"
                ) {
                    eventHandler.invoke(LoginEvent.RegistrationClick)
                }
            }
        }
    }
}

@Composable
fun HintFieldView (
    modifier: Modifier,
    description: String,
    title: String,
    handler: () -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            description,
            color = Color.Black,
            fontSize = 15.sp,
            fontFamily = Theme.fonts.montserratFamily,
            fontWeight = FontWeight.Medium
        )
        ClickableText(
            text = AnnotatedString(title),
            onClick = {handler.invoke()},
            style = TextStyle(
                color = Theme.colors.primaryColor,
                fontSize = 15.sp,
                fontFamily = Theme.fonts.montserratFamily,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun MessengersAuth(handler: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier.padding(top = 13.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.google),
            contentDescription = "Google",
            tint = Color.White,
            modifier = Modifier
                .size(40.dp)
                .background(
                    Theme.colors.primaryColor,
                    CircleShape
                )
                .padding(8.dp)
                .clickable {handler.invoke()}
        )
        Icon(
            painter = painterResource(R.drawable.apple),
            contentDescription = "Apple",
            tint = Color.White,
            modifier = Modifier
                .size(40.dp)
                .background(
                    Theme.colors.primaryColor,
                    CircleShape
                )
                .padding(8.dp)
                .clickable {handler.invoke()}
        )
        Icon(
            painter = painterResource(R.drawable.facebook),
            contentDescription = "Facebook",
            tint = Color.White,
            modifier = Modifier
                .size(40.dp)
                .background(
                    Theme.colors.primaryColor,
                    CircleShape
                )
                .padding(8.dp)
                .clickable {handler.invoke()}
        )
    }
}
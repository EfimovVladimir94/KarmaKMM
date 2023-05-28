//
//  LoginView.swift
//  Karma
//
//  Created by Vladimir on 14.05.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct LoginView: View {

    let viewState: LoginViewState
    let eventHandler: (LoginEvent) -> Void

    @State var email = ""
    @State var password = ""

    var body: some View {
        ZStack {
            Color.white.ignoresSafeArea()
            VStack(spacing: 0) {
                Image("LaunchLogo")
                    .frame(width: 227, height: 157, alignment: .center)
                    .padding(.top, 70)
                loginPassView
                    .padding(.top, 21)
                HStack {
                    Text("Забыли пароль?")
                        .foregroundColor(.black)
                        .font(.medium(15))
                    Text("Нажмите сюда")
                        .foregroundColor(.blue)
                        .font(.bold(15))
                }
                .padding(.top, 14)
                .padding(.horizontal, 10)
                Button {
                    eventHandler(.ForgotClick())
                } label: {
                    ZStack {
                        Color.blue
                        Text("Вход")
                            .font(.bold(18))
                            .foregroundColor(Color.white)
                    }
                }
                .cornerRadius(10)
                .frame(height: 53, alignment: .center)
                .padding(.top, 25)
                Spacer()
                VStack(spacing: 0) {
                    Text("Авторизироваться через соц. сети")
                        .foregroundColor(.black)
                        .font(.medium(15))
                        .frame(alignment: .center)
                    HStack(spacing: 15) {
                        Image("Instagram")
                            .frame(width: 42, height: 42, alignment: .center)
                            .background(Circle.init().foregroundColor(.blue))
                            .onTapGesture {
                            }
                        Image("Telegram")
                            .frame(width: 42, height: 42, alignment: .center)
                            .background(Circle.init().foregroundColor(.blue))
                            .onTapGesture {
                            }
                        Image("Google")
                            .frame(width: 42, height: 42, alignment: .center)
                            .background(Circle.init().foregroundColor(.blue))
                            .onTapGesture {
                            }
                    }
                    .padding(.top, 14)
                    HStack {
                        Text("Нет аккаунта?")
                            .foregroundColor(.black)
                            .font(.medium(15))
                        Text("Зарегистрироваться")
                            .foregroundColor(.blue)
                            .font(.bold(15))
                            .onTapGesture {
                                eventHandler(.RegistrationClick())
                            }
                    }
                    .padding(.top, 14)
                    .padding(.horizontal, 10)
                }
            }
            .ignoresSafeArea(.keyboard)
            .padding(.horizontal, 40)
        }
    }
}

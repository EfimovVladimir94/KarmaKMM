//
//  LoginView+LoginPassView.swift
//  Karma
//
//  Created by Vladimir on 22.05.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

extension LoginView {
    var loginPassView: some View {
        VStack(alignment: .leading, spacing: 14)  {
            CstTextField(
                text: $email,
                imageName: "Login",
                placeholder: "Логин"
            )
            .onChange(of: email, perform: {
                eventHandler(.EmailChanged(value: $0))
            })
//            if let error = viewModel.loginError {
//                Text(error)
//                    .foregroundColor(.red)
//                    .font(.regular(10))
//            }
            HStack {
                HStack(spacing: 11) {
                    Image("Password")
                        .frame(width: 21, height: 25)
                        .foregroundColor(.blue)
                        .padding(.leading, 11)
                    SecureField("", text: $password)
                        .autocapitalization(.none)
                        .placeholder(when: viewState.password.isEmpty, placeholder: {
                            Text("Пароль")
                                .foregroundColor(.gray)
                        })
                        .frame(height: 46, alignment: .center)
                        .accentColor(.blue)
                        .foregroundColor(Color.black)
                }
                .onChange(of: password, perform: {
                               eventHandler(.PasswordChanged(value: $0))
                })
                .background(Rectangle()
                    .fill(Color.white)
                    .cornerRadius(10)
                    .shadow(
                        color: Color.gray.opacity(0.7),
                        radius: 2,
                        x: 0,
                        y: 0
                    ))
            }
//            if let error = viewModel.passwordError {
//                Text(error)
//                    .foregroundColor(.red)
//                    .font(.regular(10))
//            }
        }
    }
}

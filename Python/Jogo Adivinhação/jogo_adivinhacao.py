#jogo_adivinhacao

import random

print('******************************************')
print('     Bem vindo ao Jogo de Adivinhação     ')
print('******************************************')

numero_secreto = random.randrange(1, 101)

pontos = 1000


print('Qual o nível de dificuldade do Jogo?')
print('1=Fácil 2=Médio 3=Difícil')

nivel = int(input('Defina o nível:'))

if nivel == 1:
    total_tentativas = 20
elif nivel == 2:
    total_tentativas = 10
else:
    total_tentativas = 5





for tentativa in range(total_tentativas): #0, 1, 2, 3, 4
    print('Tentativa {} de {}' .format(tentativa + 1, total_tentativas))


    chute = int(input('Digite um número entre 1 e 100: '))


    if chute == numero_secreto:
        print('Você acertou!')
        break

    else:
        pontos_perdidos = abs(numero_secreto - chute)
        pontos = pontos - pontos_perdidos


        
        if chute > numero_secreto:
            print('Errou! seu chute foi maior que o número secreto')

        else:
            print('Errou! seu chute foi menor que o número secreto')

print('Fim do Jogo')
print(f'O número secreto era: {numero_secreto}. Você fez {pontos} pontos')







    



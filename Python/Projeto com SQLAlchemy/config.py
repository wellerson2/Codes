#Framework ORM: FLASK-SQLALCHEMY

#site ofc
#https://flask-sqlalchemy.palletsprojects.com/

#terminal pycharm:
#pip install Flask Flask-SQLAlchemy
#caso ocorrer erro de segurança no terminal do pycharm:
#mudar politica de segurança no PowerShell
#A- executar como ADM o PowerShell
#B- get-executepolicy (atual)
#C- set-executepolicy RemoteSigned
#D- A(all)

import os
from flask import Flask
from flask_sqlalchemy import SQLAlchemy

#Configurando o acesso ao Banco de dados do SQLALchemy
#basedir = 'C:\Curso Python Wellerson\projeto_alchemy'
basedir = os.path.abspath(os.path.dirname(__file__))
uri = 'sqlite:///' + os.path.join(basedir, 'database.db')

#para mySQL
#mysql://username:password@host:port/database_name
#ex: 'mysql://root:senha@localhost:3306/nome_banco'

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = uri
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

#cria o banco de dados do app
db = SQLAlchemy(app)
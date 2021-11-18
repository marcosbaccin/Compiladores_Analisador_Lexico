package lexico;

public class Analisador {
	Entrada ent;
	
	public Analisador(String arquivo) {
		ent = new Entrada(arquivo);
	}
	
	public Token proximoToken() {
		int caractereLido = -1;
		
		while((caractereLido = ent.LerProximoCaractere()) != -1) {
			char c = (char) caractereLido;
			
			if (c == ' ' || c == '\n') {
				continue;
			}
			
			if (c == '&') {
				return new Token(TipoToken.logicAnd, "&");
			}
			
			else if (c == '|') {
				return new Token(TipoToken.logicOr, "|");
			}
			
			else if (c == '!') {
				c = (char) ent.LerProximoCaractere();
				if (c == '=') {
					return new Token(TipoToken.compDif, "!=");
				} else {
					return new Token(TipoToken.logicNot, "!");
				}
			}
			
			else if (c == '<') {
				c = (char) ent.LerProximoCaractere();
				if (c == '=') {
					return new Token(TipoToken.compMenorIgual, "<=");
				} else {
					return new Token(TipoToken.compMenor, "<");
				}
			}
			
			else if (c == '>') {
				c = (char) ent.LerProximoCaractere();
				if (c == '=') {
					return new Token(TipoToken.compMaior, ">=");
				} else {
					return new Token(TipoToken.compMaior, ">");
				}
			}
			
			else if (c == '=') {
				c = (char) ent.LerProximoCaractere();
				if (c == '=') {
					return new Token(TipoToken.compIgual, "==");
				} else {
					return new Token(TipoToken.atrib, "=");
				}
			}
			
			else if (c == '+') {
				c = (char) ent.LerProximoCaractere();
				if (c == '=') {
					return new Token(TipoToken.atribSoma, "+=");
				} else {
					return new Token(TipoToken.aritSoma, "+");
				}
			}
			
			else if (c == '-') {
				c = (char) ent.LerProximoCaractere();
				if (c == '=') {
					return new Token(TipoToken.atribSubt, "-=");
				} else {
					return new Token(TipoToken.aritSubt, "-");
				}
			}
			
			else if (c == '*') {
				c = (char) ent.LerProximoCaractere();
				if (c == '=') {
					return new Token(TipoToken.atribMult, "*=");
				} else {
					return new Token(TipoToken.aritMult, "*");
				}
			}
			
			else if (c == '/') {
				c = (char) ent.LerProximoCaractere();
				if (c == '=') {
					return new Token(TipoToken.atribDiv, "/=");
				} else {
					return new Token(TipoToken.aritDiv, "/");
				}
			}
			
			else if (c == '%') {
				return new Token(TipoToken.aritResto, "%");
			}
			
			else if (c == '(') {
				return new Token(TipoToken.parentAberto, "(");
			}
			
			else if (c == ')') {
				return new Token(TipoToken.parentFechado, ")");
			}
			
			else if (c == ':') {
				return new Token(TipoToken.dp, ":");
			}
			
			else if (c == 'i') {
				c = (char) ent.LerProximoCaractere();
				
				if (c == 'f') {
					return new Token(TipoToken.condIf, "if");
				}
				
				else if (c == 'n') {
					c = (char) ent.LerProximoCaractere();
					if (c == 't') {
						return new Token(TipoToken.reserv, "int");
					}
				}
			}
			
			else if (c == 'e') {
				c = (char) ent.LerProximoCaractere();
				if (c == 'l') {
					c = (char) ent.LerProximoCaractere();
					if (c == 's') {
						c = (char) ent.LerProximoCaractere();
						if (c == 'e') {
							return new Token(TipoToken.condElse, "else");
						}
					}
				}
			}
			
			else if (c == 'f') {
				c = (char) ent.LerProximoCaractere();
				if (c == 'o') {
					c = (char) ent.LerProximoCaractere();
					if (c == 'r') {
						return new Token(TipoToken.repetFor, "for");
					}
				}
			}
			
			else if (c == 'w') {
				c = (char) ent.LerProximoCaractere();
				if (c == 'h') {
					c = (char) ent.LerProximoCaractere();
					if (c == 'i') {
						c = (char) ent.LerProximoCaractere();
						if (c == 'l') {
							c = (char) ent.LerProximoCaractere();
							if (c == 'e') {
								return new Token(TipoToken.repetWhile, "while");
							}
						}
					}
				}
			}
			
			else if (c == 'p') {
				c = (char) ent.LerProximoCaractere();
				if (c == 'r') {
					c = (char) ent.LerProximoCaractere();
					if (c == 'i') {
						c = (char) ent.LerProximoCaractere();
						if (c == 'n') {
							c = (char) ent.LerProximoCaractere();
							if (c == 't') {
								return new Token(TipoToken.reserv, "print");
							}
						}
					}
				}
			}
			
			else if (c == 'r') {
				c = (char) ent.LerProximoCaractere();
				if (c == 'e') {
					c = (char) ent.LerProximoCaractere();
					if (c == 'a') {
						c = (char) ent.LerProximoCaractere();
						if (c == 'l') {
							return new Token(TipoToken.reserv, "real");
						}
					}
				}
			}
			
			else if (c == 's') {
				c = (char) ent.LerProximoCaractere();
				if (c == 't') {
					c = (char) ent.LerProximoCaractere();
					if (c == 'r') {
						return new Token(TipoToken.reserv, "str");
					}
				}
			}
			
			else if (Character.isDigit(c)) {
				while (Character.isDigit(c)) {
					c = (char) ent.LerProximoCaractere();
				}
				
				if (c == '.') {
					c = (char) ent.LerProximoCaractere();
					if (Character.isDigit(c)) {
						while (Character.isDigit(c)) {
							c = (char) ent.LerProximoCaractere();
						}
						
						return new Token(TipoToken.real, "real");
					}
				}
				
				return new Token(TipoToken.Int, "int");
			}
			
			else if (c == '"') {
				c = (char) ent.LerProximoCaractere();
				while (c != '"') {
					c = (char) ent.LerProximoCaractere();
				}
				
				return new Token(TipoToken.str, "str");
			}
			
			
			else if (Character.isLowerCase(c)) {
				c = (char) ent.LerProximoCaractere();
				while (Character.isLetterOrDigit(c)) {
					c = (char) ent.LerProximoCaractere();
				}
				
				return new Token(TipoToken.var, "var");
			}
		}
		
		return null;
	}
}

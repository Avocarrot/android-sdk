# Funções Avançadas do Avocarrot SDK

Aqui você pode encontrar tópicos avançados sobre o Avocarrot SDK.

## Conteúdo

* [Suporte Avocarrot](#Suporte-Avocarrot)
* [Dados do Usuário](#Dados-do-Usuário)
* [Log](#Log)
* [Modo Debug](#Modo-Debug)
* [Integração com Eclipse](#Integração-com-Eclipse)
* [Evitando o limite de 65K](#Evitando-o-limite-de-65K)

## Suporte Avocarrot ##

Documentos adicionais sobre a integração do Avocarrot SDK com o seu Android app pode ser encontrado clicando nos links.

- [Tutoriais Avocarrot.com](https://app.avocarrot.com/#/docs) - Tutoriais Avocarrot
- [Guia do desenvolvedor](https://app.avocarrot.com/#/docs/getting-started/android) - Guia do desenvolvedor
- [Zendesk Support](https://app.avocarrot.com/#/docs/faq) - Suporte e FAQ

## Dados do Usuário

Para transmitir as informações de uso ao Avocarrot SDK, deve-se usar os seguintes métodos estáticos:
```java
Avocarrot.setUserBirthday(data);
Avocarrot.setUserGender(UserData.Gender.FEMALE);
Avocarrot.setUserInterests(Arrays.asList("football", "auto", "cats")); // Apenas exemplos. Por favor define interesses reais.
```

## Log ##

O nível de log padrão é INFO. A partir da adb shell, você pode alterar o nível de log para DEBUG, VERBOSE e etc. Usando estes comandos:
```
setprop log.tag.Avocarrot_SDK DEBUG
```

```
setprop log.tag.MRAID DEBUG
```

```
setprop log.tag.VAST DEBUG
```

## Modo Debug ##

Caso pretenda registar as informações de debug, por favor setar `Avocarrot.setDebugMode(true)` (false por padrão), então poderá ver os logs com a tag `Avocarrot_SDK`.
Recomenda-se a utilização desta opção para efeitos de teste de integração.

## Integração com Eclipse ##

Desde que a Google tornou obsoleto o suporte ao Eclipse, recomendamos o uso do Android Studio para a integração do SDK.

### Evitando o limite de 65K ###

Caso haja erro de dex quando adicionar SDKs e adaptadores de rede de terceiros, pode ser necessário ativar o multidexing no seu arquivo build.gradle.

defaultConfig {
  ...
  multiDexEnabled true
  ...
}

Então adicione ao seu manifest a classe `MultiDexApplication` da sua biblioteca de suporte multidex para o elemento da aplicação:

```
<application
  ...
  android:name="android.support.multidex.MultiDexApplication">
  ...
</application>
```

Por favor consultar a documentação Android [aqui](https://developer.android.com/tools/building/multidex.html).

## Mais Informações:

[Para acessar o manual básico de integração com o SDK, clique aqui.](README.md)

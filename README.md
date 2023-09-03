# Aplicativo Spring Boot para Gerenciar Imagens no Amazon S3

Este é um aplicativo Spring Boot que permite gerenciar e armazenar imagens na nuvem usando o Amazon S3. Com esta aplicação, você pode realizar o upload de imagens para o Amazon S3 e buscar todas as imagens armazenadas no bucket.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Amazon S3 (AWS SDK)
- Maven

## Configuração

Antes de executar o aplicativo, você precisará configurar suas credenciais da AWS no arquivo `application-example.properties`:

```properties
# Configurações do Amazon S3
s3:
  bucketName: 'YOUR-BUCKET-NAME'
  accesskey: 'YOUR-ACCESS-KEY'
  secretkey: 'YOUR-SECRET-KEY'
```

## Endpoints

### Realizar Upload de Imagem

- **URL**: `/api/images/upload`
- **Método**: POST
- **Descrição**: Realiza o upload de uma imagem para o bucket S3.
- **Corpo da Requisição**: Envie o arquivo da imagem no corpo da requisição.

### Buscar Todas as Imagens

- **URL**: `/api/images`
- **Método**: GET
- **Descrição**: Retorna todas as imagens armazenadas no bucket S3.

## Uso

1. Execute o aplicativo conforme descrito acima.

2. Use um cliente HTTP, como o Postman ou cURL, para realizar o upload de imagens usando o endpoint `/api/images/upload`.

3. Para buscar todas as imagens no bucket S3, faça uma solicitação GET para o endpoint `/api/images`.

## Contribuições

Sinta-se à vontade para contribuir para este projeto. Você pode criar problemas (issues) ou enviar solicitações de pull requests para melhorar a funcionalidade.

## Licença

Este projeto é licenciado sob [MIT LICENSE](https://github.com/PedroTeixeiraa/gerenciador-imagens-app/blob/master/LICENSE).
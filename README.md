## Diagrama de classes

``` mermaid
classDiagram
  direction LR
  class User {
    _id: String
    firstName: String
    lastName: String
    email: String
    password: String
  }

  class Address {
    <<embedded>>
    street: String
    neighborhood: String
    city: String
    state: String
  }
  
  class Complaint {
    _id: String
    title: String
    description: String
    tag: Tag
    address: Address
    image_url: String
    user_id: String
    isAnonymouos: boolean
  }

  class StatusEnum {
    PENDING
    UNDER_REVIEW
    IN_PROGRESS
    RESOLVED
    CLOSED
    REJECTED
  }
  
  class StatusHistory {
    _id: String
    complaint_id: String
    status: StatusEnum
    created_date: Instant
    updated_date: Instant
  }

  class Tag {
    _id: String
    name: String
  }

  User "1"-- "*" Complaint
  Complaint "1"-- "*" StatusHistory
  Complaint *-- "1" Address
  Complaint "*"-- "1" Tag

```
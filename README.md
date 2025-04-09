## Diagrama de classes

``` mermaid
classDiagram
  direction LR
  class User {
    _id: String
    firstName: str
    lastName: str
    email: str
    password: str
  }

  class Address {
    <<embedded>>
    street: String
    neighborhood: String
    city: String
    state: String
  }
  
  class Complaint {
    _id: str
    title: str
    description: str
    category: Category
    address: Address
    image_url: str
    submission_date: Instant
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
    description: String
  }

  class Category {
    _id: String
    name: String
    description: String
  }

  User "1"-- "*" Complaint
  Complaint "1"-- "*" StatusHistory
  Complaint *-- "1" Address
  Complaint "*"-- "1" Category

```

# about

Backend services for the pet-project

# prerequisites

* java 11
* maven

# install

```
mvn clean install
```

# data types

## Pet Company

* uid - For Mexico, this would be the RFC. Unique identifier for the company.
* name - The name of the company.
* description - A brief description of the company to have a bit of personality in the site.
* locations - A collection of addresses which constitute all the physical locations for their facilities. A company should always have at least one (the legal address)

## Address

* street - The full name of the street with the number.
* suburb - Suburb on which this address is located.
* state - The state for the location.
* zipCode - Either zip or postal code, works fine for both.
* latitude - The altitude to locate a point in a map.
* longitude - The longitude to lcoate a point in a map.

## User

* username - A unique text based identifier for the user. Typically the email of the user.
* name - The full name of the user. Not really necessary to validate `name + lastName`, but at least validate to have something, i.e. `Carlos`.
* password - The encoded password.
* company - The company in which the user works for - it might be empty if this is a regular user (either admin or pet adopter).
* userType - Identifier to know what type of user this is, values are: `ADMIN`, `PET_COMPANY_ADMIN`, `PET_COMPANY_WORKER`, `ADOPTER`

## Adoption Request

* potentialAdopter - The person who wants to adopt the pet.
* pet - The pet they're willing to adopt.
* phoneNumber - The contact phone number from the adopter.
* email - The contact email from the adopter.
* messages - A collection of traceable messages for the whole interaction between the potential adopter and the pet company.

## Pet

* name - The name of the pet.
* description - A description of the pet, ideally, we want companies to include things like: estimated age, race, minimum requirements for adoption, brief introduction of the dog, etc.
* company - The company to whom this pet is registered under.
* location - Where the pet is physically located, can be in one of the company's facilities, or any other place.
* adopted - Flag that indicates: true if the pet has already been adopted, false if the pet is under adoption.


## Overview
Associations between objects and how they can be used in object-oriented programming. Consistent behavior between associated objects.

- [CardDeck](CardDeck.java)             -> Card Game: `Card`, `CardDeck`, and `CardHand` classes, where the last two contain one or more Card objects.
- [Merchant](Merchant.java)             -> A Merchant class with a 1-to-n association to the Item class and ensuring consistency to correctly link the objects in the assignment.
- [Partner](Partner.java)               -> `Partner` class a 1-to-1 association called "partner" back to the same class (i.e., a gender-neutral partnership), and ensuring consistency so that Partner objects are paired together correctly.
- [Person](Person.java)                 -> `Person` class a 1-to-n association with the roles of children and mother/father back to the same class (i.e., child-mother/father relationship) and ensuring consistency so that parents and children are correctly linked together.
- [StopWatchManager](StopWatchManager)  -> `StopWatchManager` class contains multiple StopWatch objects from earlier.
- [Twitter](Twitter.java)               -> `Twitter`: Two classes, `TwitterAccount` and `Tweet`.

## Class Diagram
![Class diagram](https://www.plantuml.com/plantuml/png/dLB1Rk8m4BtxAqOv1TWSLdj3AmHKgdgeL0de2N5maobrczZIs84YnBytsAObaLreSudzvitCc-SPQyF9r5N95bjX3D8aprKj3IJj-n3-9f1bHnYnkVKJi2SOkh--KtfADRxHnK9zMwYDCbSicQ4zd4Zsme3b9TUwamBBvIlVyA7Q2Bd-jrh1da7pPJ0tr21GQoJ9A_JeX8ZlxeKs_stH4HWhEnObZCJR8aRmhCfIRPk6bhclqBoeuW23ZjhKgUenw7o3azurcaSlEGtHDaeKlblQhXrbr_9g_fDI9N89Gj-U1lf55XRJtRNYhB_UbYY9qD7iguHODd3qpXvI8QzWtJIwebGXBN66velQOmVskOE85rVFfZh89n0kpZ0XFU8RUBYptzpzstkLdNjEgfhp2dr2qAJC-IXaJiWr-h6QYK8EfM45V_nSFqpoSgBRxhA_8-1x8Dvfr_0UjX8fCfADarWBoSjmm-YBZr4MTLL-0000)
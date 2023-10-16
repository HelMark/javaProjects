## Overview
Observer-Observed technique, delegation, and their use cases.

- [OfficeMain](delegation/office/OfficeMain.java)       -> A boss, or Manager, who has one or more workers, or Clerks, in a so-called one-to-many relationship. An Employee interface defines behavior common to employees and is implemented by both Manager and Clerk.
- [StockListener](observable/StockListener.java)        -> Stocks have a price, and individuals or institutions (StockListener) want to stay updated on stock prices.

## Diagrams

![Object diagram](https://www.plantuml.com/plantuml/png/TP71Ii0m38RlVOfGhvriWWS7oWJ1aoUVe7PrLDjrj1q8uhjhMsOoYwSj-VzyoVvDCScGTcV1lxnfbHwCN89qh5OWjytgv-JLEmC0Ki88gtGQRe7VvoPlzIqObGr3tr_s1z0P5NpqhmcXvnO1nwT3uMTZi-6AR5YyN-ZDM5FsO-dore7G6m9DEbg9J2m9iZGvwWtmcW3DEkkFxArl17DXXX5AfW9-0n201-D8sH1_XZunUF4d9a4_JzJBlXYhYAwxE_-pc9ye8kiV0uMtAkQ08flqEk_EVWC0)
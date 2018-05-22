# akka_typed_ping_pong

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Build Status](https://travis-ci.com/ricardomiranda/akka_typed_ping_pong.svg?branch=master)](https://travis-ci.com/ricardomiranda/akka_typed_ping_pong)
[![Codacy Badge](https://api.codacy.com/project/badge/Coverage/9332e76fb5de49dc84a18278ef920a33)](https://www.codacy.com/app/mail_62/akka_typed_ping_pong?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=ricardomiranda/akka_typed_ping_pong&amp;utm_campaign=Badge_Coverage)

PingPong is a simple program, written for illustrative purposes, where 2 players (actors) send messages back and forth between them. Constraints are:
* use typed actors;
* run in a single machine (distributed system is a future exercise);
* spawn actors from a class (not singletons);
* no supervisors (future exercise); and
* state represented in a case class.

## Authors
* **Goncalo Castro** - [Goncalo Castro](https://github.com/goncaloccastro)
* **Ricardo Miranda** - [Ricardo Miranda](https://github.com/ricardomiranda)
* **Jose Luis Valle-Flor** - [Jose Luis Valle-Flor](https://github.com/joseluisvf)

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Intro

Wizard Duel was designed in 24 hours as a part of Purdue University's introductory hackathon, Hello World 2017. None of the developers had any prior experience developing android applications, yet Wizard Duel was able to take the award for Best Android Application prize at the event.

## Background
None of us knew anything about android development at all before this project. We all had at least some experience with java through either CS180 or other classes and experience. When we first started, it took almost 3 hours to even install Android Studio on all of our computers, and that was not even including any of the time it took to figure out what we were doing. With all 4 of us working on it, it took us an hour to even get a button to work where it could switch between two screens, but, after that it started to go much faster as we got more used to the whole android development environment. The project ended up being mostly functional after about 14 hours, but it took another 8 hours to finish fixing bugs and making changes in hopes of making the app look, and feel, better.

## How we built it

The majority of the actual game flow is just a large amount of conditionals and checks to make sure that all damage healing etc. was handled properly. After every single action the UI had to be refreshed, not only so the data would be up to date, but so it could flip the screen depending on what player's turn it is and change the animations. A majority of the work we had to do was importing the gestures, then program each gesture to run the corresponding methods, and account for the multiple ways that a user could do the gesture.

## Challenges we ran into

We ran into a couple of challenges throughout the 24 hours of creating the app. One of the first ones was none of us had ever even opened Android Studio or tried Android development before this project, so we all had to learn from the very basics how to make an app. After we had the basics done, one of the first challenges we ran into was the fact that we we're trying to run everything with while loops, which we later found was not actually possible within android, and would just cause the program to crash with how we had them setup. After fixing that, our only other "big" challenge was trying to get our DPR(Damage per round) attack fully working. There were countless times where we thought it was fixed, then after more playtesting we found another bug with it. The biggest bug we had with DPR was it would only actually apply the damage to the first player that had it cast on them, and would never affect the other player.

## Accomplishments that we're proud of

Our biggest accomplishment was earning the Best Android Application award at the event. However, we are extremely proud with the game in general given that we had no experience with android development beforehand. I think our biggest accomplishment inside of the app was actually having two different forms of the game. This way the players could either play with regular buttons to cast all of the spells, or they could use fully custom gestures.

## What we learned

Everything that was in the app, we had learned during this hackathon. Beforehand, we all had some java experience, however none of us had ever even touched Android Studio beforehand. We quickly realized that the knowledge we had in java wouldn't be near enough to fully make the game, but by the end of the event we had all learned a large amount of how to make an Android app from scratch with Android Studio.

## What's next for Wizard Duel

Without completely rewriting the entire application there is not a whole lot that can be done to further add to or change the app. I think the main thing that we want to do with the app at this point is make sure that it is bug free, and everything runs as it should.

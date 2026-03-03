#### Briefly summarize the requirements and goals of the app you developed. What user needs was this app designed to address?
The app was designed to help users track inventory, whether that be for businesses, warehouses, teachers, or preppers. The requirements included having two databases: one for users and one for inventory items. The app also includes SMS permission functionality, the ability to add and delete items, edit quantities and descriptions, and attach images to items. It lets users can monitor their inventory effectively and receive notifications when necessary.

#### What screens and features were necessary to support user needs and produce a user-centered UI for the app? How did your UI designs keep users in mind? Why were your designs successful?
The necessary screens include:

- Login Screen – Allows users to log in or create an account if they are new.
- SMS Permissions Screen – Lets users grant or deny access for SMS notifications.
- Database Main Page – Displays all inventory items in a clear, grid-style layout.
- Edit Item Screen – Provides a dedicated page for editing an item’s quantity, description, image, and minimum quantity.

This keeps the appeasy on the eyes for users wihtout bombarding them with information. 

#### How did you approach the process of coding your app? What techniques or strategies did you use? How could those techniques or strategies be applied in the future?
I started by designing the UI for all the screens first, then slowly added functionality over about eight weeks. I worked on one feature at a time, testing as I went to make sure everything worked. I kept the database logic separate from the UI and organized the inventory items using classes, which made it easier to manage and fix things along the way. I find this approach really useful, since it keeps everything organized and easy to update.

#### How did you test to ensure your code was functional? Why is this process important, and what did it reveal?
I did a lot of testing using the Android Emulator. I broke the project into smaller parts so I could test each piece like login, database stuff, and editing items on its own before putting everything together. This helped me find usability issues, like realizing I needed an Edit Item screen, and catch bugs early so the app runs smoothly.

#### Consider the full app design and development process from initial planning to finalization. Where did you have to innovate to overcome a challenge?
A big challenge was figuring out how to give users access to SMS notifications without crowding the screen. I couldn’t find a clean way to add a separate SMS button on the main pages, so I ended up adding a bottom navigation bar. This gave users easy access to the SMS page while keeping the main screens clean and simple.

I also had to learn how to link pages and pass data around in Android. Luckily, it felt a lot like rerouting in React, so it wasn’t totally foreign, but it still took some trial and error to get everything navigating smoothly.

#### In what specific component of your mobile app were you particularly successful in demonstrating your knowledge, skills, and experience?
I am quite proud of the edit item page I created. The requirements for this assignment meant that I needed a way to edit the item quantity. The average smartphone has a pretty small phone screen, so it can be diffuclt to make all the buttons fit in a seamless or user friendly way. I decided to go with an item edit screen for that reason. 

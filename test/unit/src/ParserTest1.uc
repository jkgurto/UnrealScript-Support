/**
 * Comment.
 */
/*
 * Comment.
 */
// Comment
class ParserTest1 extends Mutator config(Test);

var(group) type varname;

// MyBool is visible but not editable in UnrealEd
var(MyCategory) editconst bool MyBool;

// MyBool is visible but not editable in UnrealEd and
// not changeable in script
var(MyCategory) const editconst bool MyBool;

// MyBool is visible and can be set in UnrealEd but
// not changeable in script
var(MyCategory) const bool MyBool;

var class<actor> ActorClass;

var() class C;
var actor A;

// Declare the EColor enumeration, with three values.
enum EColor
{
   CO_Red,
   CO_Green,
   CO_Blue
};

// Now, declare two variables of type EColor.
var EColor ShirtColor, HatColor;

// Alternatively, you can declare variables and
// enumerations together like this:
var enum EFruit
{
   FRUIT_Apple,
   FRUIT_Orange,
   FRUIT_Bannana
} FirstFruit, SecondFruit;

// A point or direction vector in 3D space.
struct Vector
{
   var float X;
   var float Y;
   var float Z;
};

struct LinearColor
{
   var() config float R, G, B, A;

   structdefaultproperties
   {
      A=1.f
   }
};


// Declare a bunch of variables of type Vector.
var Vector Position;
var Vector Destination;

var() float ChangeTime; // Time light takes to change from on to off.
var() bool bInitiallyOn; // Whether it's initially on.
var() bool bDelayFullOn; // Delay then go full-on.

var ELightType InitialType; // Initial type of light.
var float InitialBrightness; // Initial brightness.
var float Alpha, Direction;
var actor Trigger;

var globalconfig float fDelay;           // delay between a message (seconds)
var globalconfig int iAdminMsgDuration;// seconds that an "admin" message will stay visible
var globalconfig color cAdminMsgColor;   // color of the admin messages

const LargeNumber=123456;
const PI=3.14159;
const MyName="Tim";
//const Northeast=Vect(1.0,1.0,0.0);

const t=true;
const T=True;
const f=false;
const F=False;

var class C;
var class<Pawn> PC;
var array<int> IntList;
var array<class<PlayerController> > Players;

replication
{
    // Things the server should send to the client.
    /*if ( bNetDirty && (Role == Role_Authority) )
      Score, Deaths, bHasFlag, PlayerLocationHint,
      PlayerName, Team, TeamID, bIsFemale, bAdmin,
      bIsSpectator, bOnlySpectator, bWaitingPlayer, bReadyToPlay,
      StartTime, bOutOfLives, UniqueId;
    if ( bNetDirty && (Role == Role_Authority) && !bNetOwner )
      PacketLoss, Ping;
    if ( bNetInitial && (Role == Role_Authority) )
      PlayerID, bBot;*/

    reliable if (bNetDirty)
      PacketLoss, Ping;

    unreliable if (bNetDirty)
      PacketLoss, Ping;

}

// Example of "for" loop.
function ForExample()
{
   local int i;
   log( "Demonstrating the for loop" );
   for( i=0; i<4; i++ )
   {
      log( "The value of i is " $ i );
   }
   log( "Completed with i=" $ i);
}

// Example of "do" loop.
function DoExample()
{
   local int i;
   log( "Demonstrating the do loop" );
   do
   {
      log( "The value of i is " $ i );
      i = i + 1;
   } until( i == 4 );
   log( "Completed with i=" $ i);
}

// Example of "while" loop.
function WhileExample()
{
   local int i;
   log( "Demonstrating the while loop" );
   while( i < 4 )
   {

      log( "The value of i is " $ i );
      i = i + 1;
   }
   log( "Completed with i=" $ i);
}

function BreakExample()
{
   local int i;
   log( "Demonstrating break" );
   for( i=0; i<10; i++ )
   {
      if( i == 3 )
         break;
      log( "The value of i is " $ i );
   }
   log( "Completed with i=" $ i );
}

function ContinueExample()
{
   local int i;
   log( "Demonstrating continue" );
   for( i=0; i<10; i++ )
   {
      if( i == 2 )
         continue;
      log( "The value of i is " $ i );
   }
   log( "Completed with i=" $ i );
}

// Example of "goto".
function GotoExample()
{
       log( "Starting GotoExample" );
       goto Hither;
    Yon:
       log( "At Yon" );
       goto Elsewhere;
    Hither:
       log( "At Hither" );
       goto Yon;
    Elsewhere:
       log( "At Elsewhere" );
}


function IfElseExample() {
    // Example of simple "if".
    if( LightBrightness < 20 )
       log( "My light is dim" );

    // Example of "if-else".
    if( LightBrightness < 20 )
       log( "My light is dim" );
    else
       log( "My light is bright" );

    // Example if "if-else if-else".
    if( LightBrightness < 20 )
       log( "My light is dim" );
    else if( LightBrightness < 40 )
       log( "My light is medium" );
    else if( LightBrightness < 60 )
       log( "My light is kinda bright" );
    else
       log( "My light is very bright" );

    // Example if "if" with brackets.
    if( LightType == LT_Steady )
    {
       log( "Light is steady" );
    }
    else
    {
       log( "Light is not steady" );
    }

}

// Example of switch-case.
function TestSwitch()
{
   // Executed one of the case statements below, based on
   // the value in LightType.
   switch( LightType )
   {
      case LT_None:
         log( "There is no lighting" );
         break;
      case LT_Steady:
         log( "There is steady lighting" );
         break;
      case LT_Backdrop:
         log( "There is backdrop lighting" );
         break;
      default:
         log( "There is dynamic" );
         break;
   }
}


// Example of switch-case.
function TestSwitch2()
{
   switch( LightType )
   {
      case LT_None:
         log( "There is no lighting" );
         break;
      case LT_Steady:   // will "fall though" to the LT_Backdrop case
      case LT_Backdrop:
         log( "There is lighting" );
         break;
      default:
         log( "Something else" );
         break;
   }
}

function IterateThroughArray(array<string> SomeArray)
{
    local string ArrayItem;
    local int Index;
    foreach SomeArray(ArrayItem)
    {
        log("Array iterator test #1:"@ArrayItem);
    }
    foreach SomeArray(ArrayItem,Index)
    {
        log("Array iterator test #2:"@ArrayItem@Index);
    }
}

function TestShift() {
    if (a > b) ;
    c = a >> b;
    c = a >>> b;

    if (a < b) ;
    c = a << b;
}

function Test()
{
   local int i;
   local string s;
   local vector v, q;

   i = 10;       // Assign a value to integer variable i.
   s = "Hello!"; // Assign a value to string variable s.
   v = q;        // Copy value of vector q to v.
}

function Test()
{
    local int i;
    local string s;
    local vector v, q;
    local rotation r;
    local actor a;

    s = string(i);     // Convert integer i to a string, and assign it to s.
    s = string(v);     // Convert vector v to a string, and assign it to s.
    v = q + vector(r); // Convert rotation r to a vector, and add q.

    // casts the result of SomeFunctionCall() a class of type Actor (or subclasses of Actor)
    a = class<actor>( SomeFunctionCall() );
}

event InitGame( string Options, out string ErrorMessage );
event PreLogin( string Options, string Address, out string ErrorMessage, out string FailCode );
event PlayerController Login( string Portal, string Options, out string ErrorMessage );
event PostLogin( PlayerController NewPlayer );

function TestActorConversions()
{
   local Pawn P;

   // Cast Target to Pawn and assign the result to P.  If Target is not a Pawn (or subclass of Pawn), then the value assigned to P will be None.
   P = Pawn(Target);
   if( P != None )
   {
      // Target is a pawn, so set its Enemy to Self.
      P.Enemy = Self;
   }
   else
   {
      // Target is not a pawn.
   }
}

// Called by engine when destroyed.
function Destroyed()
{
    // Remove from owner's inventory.
    //if( Pawn(Owner)!=None )
        //Pawn(Owner).DeleteInventory( Self );
}

// Function to compute the size of a vector.
function float VectorSize( vector V )
{
   return sqrt( V.X * V.X + V.Y * V.Y + V.Z * V.Z );
}

// Function to compute the factorial of a number.
function int Factorial( int Number )
{
   if( Number <= 0 )
      return 1;
   else
      return Number * Factorial( Number - 1 );
}

// Called when something touches this actor.
function Touch( actor Other )
{
   Log( "I was touched!");
   //Other.Message( "You touched me!" );
}

function int DoSomething( int x )
{
   x = x * 2;
   return x;
}

function int DoSomethingElse()
{
   local int a, b;

   a = 2;
   log( "The value of a is " $ a );

   b = DoSomething( a );
   log( "The value of a is " $ a );
   log( "The value of b is " $ b );
}

// Compute the minimum and maximum components of a vector.
function VectorRange( vector V, out float Min, out float Max )
{
   // Compute the minimum value.
   if ( V.X<V.Y && V.X<V.Z ) Min = V.X;
   else if( V.Y<V.Z ) Min = V.Y;
   else Min = V.Z;

   // Compute the maximum value.
   if ( V.X>V.Y && V.X>V.Z ) Max = V.X;
   else if( V.Y>V.Z ) Max = V.Y;
   else Max = V.Z;
}

function ResetToDefaults()
{
   // Reset health, and stamina.
   //Health = Default.Health;
   //Stamina = Default.Stamina;
}

state MyState
{
}

auto state MyState
{
Begin:
   Log( "MyState has just begun!" );
   Sleep( 2.0 );
   Log( "MyState has finished sleeping" );
   goto('Begin');
}


// Trigger turns the light on.
state() TriggerTurnsOn
{
   function Trigger( actor Other, pawn EventInstigator )
   {
      Trigger = None;
      Direction = 1.0;
      Enable( 'Tick' );
   }
}

// Trigger turns the light off.
state() TriggerTurnsOff
{
   function Trigger( actor Other, pawn EventInstigator )
   {
      Trigger = None;
      Direction = -1.0;
      Enable( 'Tick' );
   }
}

// This is the automatic state to execute.
auto state Idle
{
   // When touched by another actor...
   function Touch( actor Other )
   {
      log( "I was touched, so I'm going to Attacking" );
      GotoState( 'Attacking' );
      Log( "I have gone to the Attacking state" );
   }
Begin:
   log( "I am idle..." );
   sleep( 10 );
   goto 'Begin';
}

// Attacking state.
state Attacking
{
Begin:
   Log( "I am executing the attacking state code" );
   //...
}

// Display a list of all lights in the level.
function Something()
{
   local actor A;

   // Go through all actors in the level.
   log( "Lights:" );
   foreach AllActors( class 'Actor', A )
   {
      if( A.LightType != LT_None )
         log( A );
   }
}

function bool CheckReplacement(Actor Other, out byte bSuperRelevant)
{
    return Super.CheckReplacement(Other, bSuperRelevant);
}


defaultproperties
{
    GroupName="KFParserTest1"
    FriendlyName="Name here"
    Description="Description here."

   // objects
   MessageClass=class'LocalMessage'

    // declare an inline subobject of class SpriteComponent named "Sprite"
   Begin Object Class=SpriteComponent Name=Sprite
       // values specified here override SpriteComponent's own defaultproperties
      Sprite=Texture2D'EngineResources.S_Actor'
      HiddenGame=true
   End Object
   //todo
   Components.Add(Sprite)

    // declare an inline subobject of class CylinderComponent named "CollisionCylinder"
   Begin Object Class=CylinderComponent Name=CollisionCylinder
       // values specified here override CylinderComponent's own defaultproperties
      CollisionRadius=10
      CollisionHeight=10
      AlwaysLoadOnClient=True
      AlwaysLoadOnServer=True
   End Object
   //todo
   Components.Add(CollisionCylinder)

   CollisionComponent=CollisionCylinder

    // floats (leading '+' and trailing 'f' characters are ignored)
   DrawScale=00001.000000
   Mass=+00100.000000
   NetPriority=00001.f

    // ints
   NetUpdateFrequency=100

    // enumerations
   Role=ROLE_Authority
   RemoteRole=ROLE_None

    // structs
   DrawScale3D=(X=1,Y=1,Z=1)

    // bools
   bJustTeleported=true
   bMovable=true
   bHiddenEdGroup=false
   bReplicateMovement=true

   // names
   InitialState=None

   // dynamic array (in this case, a dynamic class array)
   SupportedEvents(0)=class'SeqEvent_Touch'
   SupportedEvents(1)=class'SeqEvent_UnTouch'
   SupportedEvents(2)=class'SeqEvent_Destroyed'
   SupportedEvents(3)=class'SeqEvent_TakeDamage'
}

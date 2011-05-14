/**
 * Comment.
 *
 * @author asdf
 * @version 1.0
 */
/*
 * Comment.
 */
// Comment
class ParserTest1 extends Mutator config(Test)
        native
	exportstructs
        editinlinenew
	hidecategories(Movement,Collision,Lighting,LightColor,Karma,Force,Wind)
        CacheExempt HideDropDown;

#call
#error
#exec TEXTURE IMPORT NAME=NameForTextureToImportAs FILE=PATH\TO\SomeTexture.pcx GROUP=SomeGroup MIPS=OFF FLAGS=2 PALETTE=SomeTexPalette LODSET=2
#exec Texture Import File=Textures\S_Actor.pcx Name=S_Actor Mips=Off MASKED=1
#exec Texture Import File=Textures\S_Wind.tga Name=S_Wind Mips=Off
#include

`define <macroname>[<(paramA[,paramB...])>] [<macrodefinition>]
`if(<value>)
`else
`endif
`include(<filename>)
`isdefined(<macroname>)
`notdefined(<macroname>)
`undefine(<macroname>)
`log(string OutputString, optional bool bRequiredCondition, optional name LogTag);
`warn(string OutputString, optional bool bRequiredCondition);
`logd(string OutputString, optional bool bRequiredCondition, optional name LogTag);
`assert(bool bCondition);

var(group) type varname;

// MyBool is visible but not editable in UnrealEd
var(MyCategory) editconst bool MyBool;

// MyBool is visible but not editable in UnrealEd and
// not changeable in script
var(MyCategory) const editconst bool MyBool;

// MyBool is visible and can be set in UnrealEd but
// not changeable in script
var(MyCategory) const bool MyBool;

var(Object) name InitialState;

var pointer varname{int};
var pointer varname{type};
var const pointer      pCanvasUtil; // sjs
var cache string SoundPackage;

struct CachedSound
{
	var name CacheName;
	var sound CacheSound;
};

struct native init MutatorRecord
{
    var() const     string      ClassName;
    var() const     string      FriendlyName;
    var() const     string      Description;
    var() const     string      IconMaterialName;
    var() const     string      ConfigMenuClassName;
    var() const     string      GroupName;
    var   const     int         RecordIndex;
    var   const     byte        bActivated;
};

var class<actor> ActorClass;

var(Object) native const editconst noexport name Name;

struct Guid
{
	var int A, B, C, D;
};

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
var object o;

var globalconfig float fDelay;           // delay between a message (seconds)
var globalconfig int iAdminMsgDuration;// seconds that an "admin" message will stay visible
var globalconfig color cAdminMsgColor;   // color of the admin messages

const LargeNumber=123456;
const PI=3.14159;
const MyName="Tim";
const Northeast=Vect(1.0,1.0,0.0);

const t=true;
const T=True;
const f=false;
const F=False;

const a=blah;
const a=blah.blah();
const a=1+2+3+4;

var class C;
var class<Pawn> PC;
var array<int> IntList;
var array<class<PlayerController> > Players;
var array<class<Object> > Players;

const PROPNUM = 4;
var localized string ACDisplayText[PROPNUM];
var localized string ACDescText[PROPNUM];
var(Events) name          Event;         // The event this actor causes.

/// @todo FIXME
//var localized int variablename<tag1=value|tag2=value>;

var(Path) config enum EPathStyle
{
	PATHSTYLE_Linear,
	PATHSTYLE_Bezier
} PathStyle;

cpptext{}

const a=blah;

cpptext { }

const a=blah;

cpptext
{
    //...
    void DrawTile(UTexture* Tex,
                  FLOAT X, FLOAT Y,
                  FLOAT XL, FLOAT YL,
                  FLOAT U, FLOAT V,
                  FLOAT UL, FLOAT VL,
                  const FLinearColor& Color);
    virtual void ResolutionChanged(int ResX, int ResY) {}
    virtual void ResetInput() {}
    //...

    // AnimNotify interface.
	virtual void Notify( UMeshInstance *Instance, AActor *Owner ) {};
	// UObject interface.
	virtual void PostEditChange();

    virtual FColor GetColor(FLOAT TimeSeconds) { return Color; }
}

const a=blah;

cpptext{
#ifdef WITH_KARMA
    virtual MdtConstraintID getKConstraint() const;
    virtual McdModelID getKModel() const;

	virtual void physKarma(FLOAT DeltaTime);

	virtual void PostEditChange();
	virtual void PostEditMove();

    virtual void KUpdateConstraintParams();

	virtual void CheckForErrors(); // used for checking that this constraint is valid buring map build
	virtual void RenderEditorSelected(FLevelSceneNode* SceneNode,FRenderInterface* RI, FDynamicActor* FDA);
	virtual UBOOL CheckOwnerUpdated();

	virtual void preKarmaStep(FLOAT DeltaTime) {};
	virtual void postKarmaStep() {};
#endif

virtual void PostEditChange();
	virtual UBOOL CheckCircularReferences( TArray<class UMaterial*>& History );
	virtual void PreSetMaterial(FLOAT TimeSeconds);
	virtual void Serialize(FArchive& Ar);
}

const a=blah;

/// @todo FIXME nested braces
/*cpptext
{
	// UTexModifier interface
	virtual FMatrix* GetMatrix(FLOAT TimeSeconds);
	void PostLoad()
	{
		Super::PostLoad();
		//!!OLDVER
		if( ConstantRotation )
		{
			ConstantRotation = 0;
			TexRotationType = TR_ConstantlyRotating;
		}
	}

        { {asd {asd} } } {}
}*/

const a=blah;

/*cpptext
{
	void Render(FRenderInterface* RI);

	virtual UBitmapMaterial* Get(FTime Time,UViewport* Viewport);
	virtual FBaseTexture* GetRenderInterface();
	virtual void Destroy();
	virtual void PostEditChange();
};*/

const a=blah;

var()	SceneSubtitles.ESST_Mode SubTitleMode;
var() TexOscillatorTriggered.ERetriggerAction RetriggerAction;
var		(Global)	rangevector			GlobalOffsetRange;
var (Local)			bool						RespawnDeadParticles;
var() editinline editconst noexport private   editconstarray transient array<int>    RandomPool;
var private pointer NativeID3Tag[2];

replication
{
    // Things the server should send to the client.
    if ( bNetDirty && (Role == Role_Authority) )
      Score, Deaths, bHasFlag, PlayerLocationHint,
      PlayerName, Team, TeamID, bIsFemale, bAdmin,
      bIsSpectator, bOnlySpectator, bWaitingPlayer, bReadyToPlay,
      StartTime, bOutOfLives, UniqueId;
    if ( bNetDirty && (Role == Role_Authority) && !bNetOwner )
      PacketLoss, Ping;
    if ( bNetInitial && (Role == Role_Authority) )
      PlayerID, bBot;

    reliable if (bNetDirty)
      PacketLoss, Ping;

    unreliable if (bNetDirty)
      PacketLoss, Ping;
}

native final function EnableChannelNotify ( int Channel, int Switch );
native final function bool GetCacheEntry( int Num, out string GUID, out string Filename );
native final simulated function SetBoneRotation( name BoneName, optional rotator BoneTurn, optional int Space, optional float Alpha );
event TakeDamage(int Damage, Pawn EventInstigator, vector HitLocation, vector Momentum, class<DamageType> DamageType);
function bool HealDamage(int Amount, Controller Healer, class<DamageType> DamageType);

native(130) static final operator(30) bool  && ( bool A, skip bool B );

native(277) final function Actor Trace
(
	out vector      HitLocation,
	out vector      HitNormal,
	vector          TraceEnd,
	optional vector TraceStart,
	optional bool   bTraceActors,
	optional vector Extent,
	optional out material Material
);

native simulated final function PlayOwnedSound
(
	sound				Sound,
	optional ESoundSlot Slot,
	optional float		Volume,
	optional bool		bNoOverride,
	optional float		Radius,
	optional float		Pitch,
	optional bool		Attenuate
);

// Draw a vertical line
final function DrawVertical(float X, float height)
{
	local float cX,cY;

	CX = CurX; CY = CurY;
    CurX = X;
    DrawTile(Texture'engine.WhiteSquareTexture', 2, height, 0, 0, 2, 2);
    CurX = CX; CurY = CY;
}

// In this state nothing will happen if this hinge is triggered or untriggered.
auto state Default
{
ignores Trigger, Untrigger;

}

event PostBeginPlay()
{
	if ( Maps.Length == 0 )
		Warn(Name@"has no maps configured!");

	Super.PostBeginPlay();
}

// static function
static function GetHitEffects( out class<xEmitter> HitEffects[4], int VictemHealth );

// function static
function static int GetNumPositions()
{
	return NUM_POSITIONS;
}

static function string GetString(
    optional int Switch,
    optional PlayerReplicationInfo RelatedPRI_1,
    optional PlayerReplicationInfo RelatedPRI_2,
    optional Object OptionalObject
    )
{
    if ( class<Actor>(OptionalObject) != None )
        return class<Actor>(OptionalObject).static.GetLocalString(Switch, RelatedPRI_1, RelatedPRI_2);
    return "";

    desire *= (class<Armor>(InventoryType).default.ArmorAbsorption * 0.01);
}

simulated function DrawRoute()
{
    local int i;
    local Controller C;
    /// @todo FIXME
    //local vector Start, End, RealStart;;
    local vector Start, End, RealStart;
    local bool bPath;
}

final function Dump( optional string group )
{
local int i;
	log("** Dumping settings array for PlayInfo object '"$Name$"' **");

	log("** Classes:"@InfoClasses.Length);
	for ( i = 0; i < InfoClasses.Length; i++ )
		log("   "$i$")"@InfoClasses[i].Name);
	log("");

	log("** Groups:"@Groups.Length);
	for (i = 0; i < Groups.Length; i++)
		log("   "$i$")"@Groups[i]);
	log("");

	Log("** Settings:"@Settings.Length);
	for (i = 0; i<Settings.Length; i++)
	{
		if ( group == "" || group ~= Settings[i].Grouping )
		{
			Log(i$")"@Settings[i].SettingName);
			log("            DisplayName:"@Settings[i].DisplayName);
			log("              ClassFrom:"@Settings[i].ClassFrom);
			log("                  Group:"@Settings[i].Grouping);
			log("                  Value:"@Settings[i].Value);
			log("                   Data:"@Settings[i].Data);
			log("                 Weight:"@Settings[i].Weight);
			log("                 Struct:"@Settings[i].bStruct);
			log("                 Global:"@Settings[i].bGlobal);
			log("                 MPOnly:"@Settings[i].bMPOnly);
			log("               SecLevel:"@Settings[i].SecLevel);
			log("               ArrayDim:"@Settings[i].ArrayDim);
			log("              bAdvanced:"@Settings[i].bAdvanced);
			log("              ExtraPriv:"@Settings[i].ExtraPriv);
			log("             RenderType:"@GetEnum(enum'EPlayInfoType',Settings[i].RenderType));
			log("");
		}
	}
}

simulated function Timer()
{
	local int i;
	local PlayerReplicationInfo OldHolder[2];
	local Controller C;
}

function InitVoiceReplicationInfo()
{
	log(Name@"VoiceReplicationInfo created:"@VoiceReplicationInfo,'VoiceChat');
}

function FunctionExample(name Event) { }

function FunctionExample(actor Other)
{
    local name Event;         // The event this actor causes.
    Event.func();
    varname.Event.func();

    Super.FunctionExample(other);
    Super(Pawn).Touch( Other );
    Global.Touch( Other );
    Super.Touch( Other );

    C = Spawn(P.ControllerClass,,,P.Location, P.Rotation);
    GetItemName(String(MoveTarget));
    i = MapHandler.GetGameIndex(string(Level.Game.Class));

    // Check empty string
    if (Mid(Params, p, 1) == "") { ; }

    // Check nested quotes
    // "
    if (Mid(Params, p, 1) == "\"") { ; }
    // '
    if (Mid(Params, p, 1) == "\'") { ; }
    // '
    if (Mid(Params, p, 1) == "'") { ; }

    // Check nested escapes "\\"
    // \"
    if (Mid(Params, p, 1) == "\\\"") { ; }
    // \
    if (Mid(Params, p, 1) == "\\") { ; }
    // newline
    if (Mid(Params, p, 1) == "\n") { ; }
    // \n
    if (Mid(Params, p, 1) == "\\n") { ; }
}

static function FillPlayInfo(PlayInfo PlayInfo)
{
local int i;

	Super.FillPlayInfo(PlayInfo);  // Always begin with calling parent

	i=0;
	PlayInfo.AddSetting(default.ServerGroup,      "GamePassword", default.ACDisplayText[i++], 240, 1, "Text",      "16",,True,True);
	PlayInfo.AddSetting(default.ServerGroup,        "IPPolicies", default.ACDisplayText[i++], 254, 1, "Text",      "15",,True,True);
	PlayInfo.AddSetting(default.ServerGroup,     "AdminPassword", default.ACDisplayText[i++], 255, 1, "Text",      "16",,True,True);
	PlayInfo.AddSetting(default.ServerGroup, "LoginDelaySeconds", default.ACDisplayText[i++], 200, 1, "Text", "3;0:999",,True,True);
}

static event string checkSwitch(string PropName)
{
        switch (e)
	{
            default:
                e();
	}

        switch (e)
	{
            case a:
            case b:
            case c:
                d();
                if(asdf) { ; }
                e();
            default:
                e();
                f();
                if(asdf) { ; }
	}

        switch (e)
	{
            case a:
            case b:
            case c:
                d();
            default:
                e();
	}

        switch (ee)
	{
		case aa:
                    a();
		case bb:
                    b();
		case cc:
                    c();
		case dd:
                    d();
	}

        switch (PropName)
	{
		case "GamePassword":
		case "IPPolicies":
		case "AdminPassword":
		case "LoginDelaySeconds":
                    return a;
	}

        switch (PropName)
	{
		case "GamePassword":
                    a();
		case "IPPolicies":
                    b();
		case "AdminPassword":
                    c();
		case "LoginDelaySeconds":
                    d();
	}

	switch (PropName)
	{
		case "GamePassword": 	  return default.ACDescText[0];
		case "IPPolicies":		  return default.ACDescText[1];
		case "AdminPassword":	  return default.ACDescText[2];
		case "LoginDelaySeconds": return default.ACDescText[3];
	}

        // Take the appropriate action depending on the result received from the VoiceReplicationInfo
	switch ( Result )
	{
		case JCR_NeedPassword:  ClientOpenMenu(ChatPasswordMenuClass, false, VCR.GetTitle(), "NEEDPW");     break;
		case JCR_WrongPassword: ClientOpenMenu(ChatPasswordMenuClass, False, VCR.GetTitle(), "WRONGPW");	break;
		case JCR_Success:       Level.Game.ChangeVoiceChannel(PlayerReplicationInfo, ChannelIndex, -1);
		default:
			if ( ChannelIndex>VoiceReplicationInfo.GetPublicChannelCount(true) )
				ChatRoomMessage(Result, ChannelIndex);

	}

	return Super.GetDescriptionText(PropName);
}

function object FunctionExample(object o) { return o; }

simulated function CheckOutOfAmmo()
{
    if (AmmoAmount <= 0)
        Pawn(Owner).Weapon.OutOfAmmo();

    testPawnArray[1].Weapon.OutOfAmmo();
}

function void OperatorExample() {

    local string str1;
    local string str2;
    local int i;
    local float a;
    local float b;
    local bool x;
    local bool y;
    local vector v;
    local actor a;
    local object object1;
    local array<string> Ar;

    for ( i=0; i<16; i++ )
    {
        if ( RouteCache[i] == None )
        {
            if ( i > 5 )
                T = T$"--"$GetItemName(string(RouteCache[i-1]));
            break;
        }
        else if ( i < 5 )
            T = T$GetItemName(string(RouteCache[i]))$"-";
    }

    str1 = "abc";
    str2 = "def";
    i = int(7.0);
    a = 2.0;
    b = 3.0;
    x = true;
    y = false;
    v = vector(1.0, 1.0, 1.0);
    a = actor(obj);
    a = a.b;
    a = a.b(c, d, (e()));
    a = a.b.c;
    //a = a.b.c(object.x);
    a = a.b.c(d, e.f, g.h.i());
    a = class'MyClass'.default.variable;
    a = class'MyClass'.static.funcCall();
    a = class'MyPackage.MyClass'.static.funcCall();
    class'MyClass'.default.variable = 1;
    a = class'SomeClass'.const.SOMECONST;
    //a = object.x;

    a = b + 1 + b;
    a = 1 + b + 1;

    str1 = str2@"ghi"@str2;
    str1 @= "ghi"@str2@"ghi";
    str1 = "ghi"$str2$"jkl";
    str1 $= str2$"ghi"$str2;
    str1 = str2$"ghi"@str2;

    i = ~i;

    a = -3;
    a = +3;
    a = -a;
    a = ++a;
    a = --a;
    a = a++;
    a = a--;
    a = a++ + -4.0 * --x;

    a *= -2 * (3 * -4.0) / 5.0 + b - (+6);
    a = a ** 2;

    x = y && true || false ^^ y && !true && !y;
    y = (a ~= b);
    y = str1 ~= str2;
    y = a > b;
    y = str1 < str2;
    y = !y;

    v = v >> 5;
    v = v << 5.0;
    v = v dot vector(2, 2, 2);
    v = v cross vector(2, 2, 2);

    return;
}

// Delegate
// a negative return value indicates the items should be swapped
delegate int ExampleSort(ArrayType A, ArrayType B)
{ return A < B ? -1 : 0; }

// UnrealScript 3
// Default function arguments
function myFunc(optional int x = -1) {}

// Native functions
native(266) final function bool Move( vector Delta );
native function int doSomething(string myData) const;

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

    while( i < 4 )
      i = i + 1;
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

    for( i=0; i<10; i++ )
      log( "The value of i is " $ i );
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
    else if( LightBrightness < 40 )
    {
       log( "Light is not steady and medium" );
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
        log("Array iterator test #1:"@ArrayItem);

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

function void checkNew() {

    local Object O;

    local class<WebApplication> WAClass;
    local class<Object> OClass;
    local Object O;
    local WebApplication WA;

    O = new class'TestClass';
    O = new(Self) class'TestClass'; // O.Outer == Self
    O = new(None, 'ExampleObject') class'TestClass'; // O.Name == 'ExampleObject'
    O = new(None, '', RF_Transient) class'TestClass'; // makes O transient even if TestClass isn't
    O = new(None, '', 0) class'TestClass' (TestClass'TemplateObject'); // duplicates TemplateObject

    

    WAClass = class'UTServerAdmin';
    OClass = class'UTServerAdmin';

    WA = new class'UTServerAdmin'; // works because UTServerAdmin extends WebApplication
    WA = new WAClass; // works because the metaclass of WAClass is WebApplication
    O = new WAClass; // works because WebApplication extends Object
    O = new OClass;  // works because the metaclass of OClass is Object
    O = new pkg.OClass;

    Level.ObjectPool = new(xLevel) class'ObjectPool';

    if(Result == None)
		Result = new(Outer) ObjectClass;

NewObj = new class'Engine.LightFunction';
NewObj = new(Self,'NewLight') class'Engine.LightFunction';
NewObj = new(None,'NewLight') class'Engine.LightFunction' (LightFunctionTemplate);
Result = new(Outer) ObjectClass;
return new(None, Repl(RecordName, " ", Chr(27))) class'MaplistRecord';
AdminManager = new(self) Level.Game.AccessControl.AdminClass;
AddCameraEffect(new EffectClass);
FireMode[m] = new(self) FireModeClass[m];

    if ( Level.ObjectPool == None )
		Level.ObjectPool = new(xLevel) class'ObjectPool';

    if ( AdminManager == None && Level != None && Level.Game != None && Level.Game.AccessControl != None)
	{
		if (Level.Game.AccessControl.AdminClass == None)
			Log("AdminClass is None");
		else
			AdminManager = new(self) Level.Game.AccessControl.AdminClass;
	}

}

final operator(18) int : ( int A, int B )
{
  return (A + B) / 2;
}

/*final postoperator int # (int A)
{
  return A / 10;
}

final postoperator int # ( out int A )
{   return A /= 10; // Notice how A is modified here
}

static final postoperator int #( out int A )
{
  return A /= 10;
}*/

static final operator(22) string * ( coerce string A, int B )
{
  local string Build;
  local int i;

  for(i=0;i<B;i++)
    Build = Build$A;
  return Build;
}

// Extend vector by an unit length
static final preoperator vector ++ ( out vector A )
{
  return A += Normal(A);
}

// Shrink operator by an unit length
static final preoperator vector -- ( out vector A )
{
  return A -= Normal(A);
}

// Same thing, but postop
static final postoperator vector ++ ( out vector A )
{
  local vector B;
  B = A;
  A += Normal(A);
  return B;
}

static final postoperator vector -- ( out vector A )
{
  local vector B;
  B = A;
  A += Normal(A);
  return B;
}

// Lighten color by 1
static final preoperator color ++ ( out color A )
{
  A.R++;
  A.G++;
  A.B++;
  return A;
}

// Darken color by 1
static final preoperator color -- ( out color A )
{
  A.R--;
  A.G--;
  A.B--;
  return A;
}

// Postoperator version
static final postoperator color ++ ( out color A )
{
  local color Copy;
  Copy = A;
  A.R++;
  A.G++;
  A.B++;
  return Copy;
}

// Postoperator version
static final postoperator color -- ( out color A )
{
  local color Copy;
  Copy = A;
  A.R--;
  A.G--;
  A.B--;
  return Copy;
}

// Remember that averaging operator we just used? Now it's suddenly useful, so I've copied it into here
final operator(18) int : ( int A, int B )
{
  return (A + B) / 2;
}

// Interpolate 2 colors
static final operator(22) color Mix ( color A, color B )
{
  local Color Result;
  Result.R = A.R : B.R;
  Result.G = A.G : B.G;
  Result.B = A.B : B.B;
  return Result;
}

// UT Provides a * operator for colors, but no /. Ramp a color by a float
static final operator(16) color / ( color A, float B )
{
  local Color Result;
  Result.R = A.R / B;
  Result.G = A.G / B;
  Result.B = A.B / B;
  return Result;
}

// Same thing, but this one affects the color
static final operator(34) color /= ( out color A, float B )
{
  A = A / B;
  return A;
}

// UT Provides *, not *=, so let's implement it
static final operator(34) color *= ( out color A, float B )
{
  A = A * B;
  return A;
}

// Add a byte value to each component
static final operator(20) color + ( color A, byte B )
{
  local Color Result;
  Result.R = A.R + B;
  Result.G = A.G + B;
  Result.B = A.B + B;
  return Result;
}

// Subtract a byte value to each component
static final operator(20) color - ( color A, byte B )
{
  local Color Result;
  Result.R = A.R - B;
  Result.G = A.G - B;
  Result.B = A.B - B;
  return Result;
}

// Out versions of the operators
static final operator(34) color += ( out color A, byte B )
{
  A = A + B;
  return A;
}

static final operator(34) color -= ( out color A, byte B )
{
  A = A - B;
  return A;
}

// Out version of the operator UT provides
static final operator(34) color += ( out color A, color B )
{
  A = A + B;
  return A;
}

static final operator(34) color -= ( out color A, color B )
{
  A = A - B;
  return A;
}

// We can't use static because we're calling Destroy(), a non-static function
final postoperator Actor DIEDIEDIE ( out Actor NearlyDead )
{
  NearlyDead.Destroy();
  return NearlyDead;
}

function testOperator() {
    local int middle;

    Middle = 10 : 2; // Middle = 6
    Middle = 10 + 2 : 4; // Middle = (10 + 2) : 4 = 8

    /*i = 100;

    b = i#; // b = 10, i = 100 (i is NOT affected)

    i = 100;

    b = i#; // b = 10, i = 10 (i IS affected, because of the out keyword)

    i#; // i = 1

    SomeActor DIEDIEDIE; // It is now dead.*/
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
    Components.Add(Sprite)

    // declare an inline subobject of class CylinderComponent named "CollisionCylinder"
    Begin Object Class=CylinderComponent Name=CollisionCylinder
       // values specified here override CylinderComponent's own defaultproperties
      CollisionRadius=10
      CollisionHeight=10
      AlwaysLoadOnClient=True
      AlwaysLoadOnServer=True
    End Object
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

    // Simple Types (Ints, Floats, Bools, Bytes):
    VarName=Value
    VarName=1
    VarName=2.0
    VarName=true
    VarName=class'SeqEvent_TakeDamage'
    VarName=None
    VarName='name'
    VarName=ObjectClass'ObjectName'

    //Static Array:
    ArrayProp(i)=Value1
    ArrayProp(0)=Value1
    ArrayProp(1)=1
    ArrayProp(2)=+2.0f
    ArrayProp(3)=true
    ArrayProp(4)=class'SeqEvent_TakeDamage'
    ArrayProp(5)=None
    ArrayProp(6)='name'
    ArrayProp(7)=ObjectClass'ObjectName'
    // OR
    ArrayProp[i]=Value1
    ArrayProp[0]=Value2
    ArrayProp[1]=1
    ArrayProp[2]=+2.0f
    ArrayProp[3]=true
    ArrayProp[4]=class'SeqEvent_TakeDamage'
    ArrayProp[5]=None
    ArrayProp[6]='name'
    ArrayProp[7]=ObjectClass'ObjectName'

    //Dynamic Arrays:
    ArrayProp=(Value1,Value2,Value3)
    ArrayProp=(Value1,
               1,
               +2.0f,
               true,
               class'SeqEvent_TakeDamage',
               None,
               'name',
               ObjectClass'ObjectName')
    //OR
    ArrayProp(0)=Value1
    ArrayProp(1)=Value2
    ArrayProp(2)=Value3
    //OR
    ArrayProp.Add(Value1)
    ArrayProp.Add(1)
    ArrayProp.Add(+2.0f)
    ArrayProp.Add(true)
    ArrayProp.Add(class'SeqEvent_TakeDamage')
    ArrayProp.Add(None)
    ArrayProp.Add('name')
    ArrayProp.Add(ObjectClass'ObjectName')

    // Structs (including Vectors):
    StructProperty=(InnerStructPropertyA=Value1,InnerStructPropertyB=Value2)
    StructProperty=(a=Value1,
                    b=1,
                    c=+2.0f,
                    d=true,
                    e=class'SeqEvent_TakeDamage',
                    f=None,
                    g='name',
                    h=ObjectClass'ObjectName')
    // OR
    StructProperty={(
                InnerStructPropertyA=Value1,
                InnerStructPropertyB=Value2
                )}
    StructProperty={(
                a=Value1,
                b=1,
                c=+2.0f,
                d=true,
                e=class'SeqEvent_TakeDamage',
                f=None,
                g='name',
                h=ObjectClass'ObjectName'
                )}

    // Subobjects
    Begin Object Class=ObjectClass Name=ObjectName
        VarName=Value
        e=Value
        VarName=1
        VarName=+2.0f
        VarName=true
        VarName=class'SeqEvent_TakeDamage'
        VarName=None
        VarName='name'
        VarName=Obj
    End Object
    ObjectProperty=ObjectName

    // Names
    NameProp='Value'
    //OR
    NameProp=Value

    // Objects
    ObjectProp=ObjectClass'ObjectName'

    MainScale=(Scale=(X=1,Y=1,Z=1),SheerRate=0,SheerAxis=SHEER_None)
    DefaultContent(0)=(Classes=("UTClassic.MutUTClassic",
    "UnrealGame.MutLowGrav","UnrealGame.MutBigHead",
    "XGame.xTeamGame","XGame.xDeathMatch","XGame.xCTFGame",
    "XGame.InstagibCTF","XGame.xVehicleCTFGame","XGame.xDoubleDom",
    "XGame.xBombingRun","XGame.MutRegen","XGame.MutInstaGib",
    "XGame.MutQuadJump","XGame.MutSpeciesStats","XGame.MutVampire",
    "XGame.MutSlomoDeath","XGame.MutNoAdrenaline","XGame.MutZoomInstagib",
    "XWeapons.Translauncher","XWeapons.ShockRifle","XWeapons.LinkGun",
    "XWeapons.MutArena","XWeapons.Minigun","XWeapons.BioRifle",
    "XWeapons.FlakCannon","XWeapons.RocketLauncher",
    "XWeapons.ShieldGun","XWeapons.SniperRifle","XWeapons.Painter",
    "XWeapons.MutNoSuperWeapon","XWeapons.AssaultRifle","XWeapons.Redeemer",
    "Vehicles.Bulldog"),
    Maps=("BR-Anubis","BR-Bifrost","BR-Disclosure",
    "BR-IceFields","BR-Skyline","BR-Slaughterhouse","BR-TwinTombs",
    "CTF-Chrome","CTF-Citadel","CTF-December","CTF-Face3","CTF-Geothermal",
    "CTF-Lostfaith","CTF-Magma","CTF-Maul","CTF-Orbital2","DM-Antalus",
    "DM-Asbestos","DM-Compressed","DM-Flux2","DM-Gael","DM-Inferno",
    "DM-Insidious","DM-Leviathan","DM-Oceanic","DM-Phobos2","DM-Plunge",
    "DM-1on1-Serpentine","DM-TokaraForest","DM-TrainingDay","DOM-Core",
    "DOM-OutRigger","DOM-Ruination","DOM-ScorchedEarth","DOM-SepukkuGorge",
    "DOM-Suntemple","TUT-BR","TUT-CTF","TUT-DM","TUT-DOM2"))

    AlphaOperation=AO_Use_Mask;
    // MT_Combiner
    MaterialType=2

Steering=0
    Throttle=0

	ExitPositions(0)=(X=0,Y=0,Z=0)

	DrivePos=(X=0,Y=0,Z=0)
	DriveRot=()

	bHistoryWarmup = true;


    Physics=PHYS_Karma
	bEdShouldSnap=True
	bStatic=False
	bShadowCast=False
	bCollideActors=True
	bCollideWorld=False

}

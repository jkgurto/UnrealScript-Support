
class ${name} extends Mutator;

function bool CheckReplacement(Actor Other, out byte bSuperRelevant)
{
    return Super.CheckReplacement(Other, bSuperRelevant);
}

defaultproperties
{
    GroupName="KF${name}"
    FriendlyName="Name here"
    Description="Description here."
}

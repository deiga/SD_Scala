var argsList = List[String]()
for (arg <- args) {
    argsList = arg :: argsList
}

argsList.sort((a: String, b: String) => a < b ).foreach(println)

args.toList.sort(_<_).foreach(println)
var argsList = List[String]()
for (arg <- args) {
    argsList = arg :: argsList
}

println(argsList.sort((a: String, b: String) => a < b ))
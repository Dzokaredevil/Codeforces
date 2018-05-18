$\ = $/;
<>;

@_ = split ' ', <>;

$h = 1;

for( split ' ', <> ){ 
	
	while( @_ and $_[ 0 ] + $c < $_ ){
		$h ++;
		$c += shift @_;
		}
	
	print "$h " . ( $_ - $c )
	}
